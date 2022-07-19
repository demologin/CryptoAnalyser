package ru.javarush.cryptoanalyser.didukh.commands;

import ru.javarush.cryptoanalyser.didukh.constans.Strings;
import ru.javarush.cryptoanalyser.didukh.entity.Result;
import ru.javarush.cryptoanalyser.didukh.entity.ResultCode;
import ru.javarush.cryptoanalyser.didukh.exeption.ApplicationExeption;
import ru.javarush.cryptoanalyser.didukh.util.PathFinder;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Brute implements Action{
    @Override
    public Result execute(String[] parameters){
        String txtFile = parameters[0];
        String encryptFile = parameters[1];
        String exampleFile = parameters[2];
        Path path = Path.of(PathFinder.getRoot() + txtFile);
        Path path2 = Path.of(PathFinder.getRoot() + exampleFile);
        String[] exampleFileInStringArray = fileToStringArray(path2);
        try {
            char[] strings = Files.readAllLines(path).toString().toCharArray();  // массив чаров закодированного файла
            char[] alphabet = Strings.ALPHABET.toCharArray();                    // массив алфавита
            HashMap<Integer,Integer> countOfcoincidence = new HashMap<>();       // список где ключ ето количество слов которые совпали, а значение ето ключ
            for(int key = 1; key < alphabet.length; key++){
                ArrayList<Character> alphabetList = new ArrayList<>();           // ерейлист алфавита
                for (char c : alphabet) {
                    alphabetList.add(c);                                         // заполняем ерейлист алфавита
                }
                Collections.rotate(alphabetList,key);
                char[] resultChars = decode(strings,alphabet,alphabetList);
                String input = Arrays.toString(resultChars);
                StringBuilder sb = new StringBuilder(input);
                for (int i = 2; i< sb.length();i+=2){
                    sb.delete(i,i+1);
                }
                String[] resultStringArray = sb.toString().split(" {2}");            // на етом месте я стопорнулся гдето часа так на 3, пока не понял что нужно 2-а пробела
                for (String s : exampleFileInStringArray) {                    // перебор слов из файла-примера
                    int count = 0;                                             // переменная которая хранит количество совпадений
                    for (String value : resultStringArray) {                   // перебор слов из закодированного файла
                        if (s.equalsIgnoreCase(value)) {
                            count++;
                        }
                    }
                    countOfcoincidence.put(count,key);
                }
            }
            ArrayList<Character> alphabetList2 = new ArrayList<>();             // ерейлист алфавита
            for (char c : alphabet) {
                alphabetList2.add(c);                                           // заполняем ерейлист алфавита
            }
            Collections.rotate(alphabetList2,getTrueKey(countOfcoincidence));
            char[] result = decode(strings,alphabet,alphabetList2);             // создаем новый массив чаров для хранения уже разкодированого текста в чарах
            writeDecoderedText(encryptFile,result);
        } catch (IOException e) {
            throw new ApplicationExeption("IO error",e);
        }
        return new Result(ResultCode.OK,"read all lines" + path);
    }


    private static String[] fileToStringArray (Path filename) {
        List<String> text = new List<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public String set(int index, String element) {
                return null;
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        try {
            String a = Files.readAllLines(filename).toString();
            String[] stringArray = a.split(" ");
            text = Arrays.asList(stringArray);
        } catch (IOException exc) {
            System.out.println("Ошибка преобразования файла в массив слов " + exc);
        }
        return text.toArray(new String[0]);
    }

    private char[] decode(char[] strings, char[] alphabet, ArrayList<Character> alphabetList){
        char[] resultChars = new char[strings.length];
        for(int i = 0; i < strings.length; i++){
            for (int b = 0; b < alphabet.length; b++ ){
                int charCode1 = strings[i];
                int charCode2 = alphabet[b];
                if(charCode1 == charCode2){
                    resultChars[i] = alphabetList.get(b);
                    break;
                }
            }
        }return resultChars;
    }

    private void writeDecoderedText(String outFile, char[] resultChars){
        StringWriter writer = new StringWriter();
        writer.write(resultChars, 0, resultChars.length);
        Path pathOut = Path.of(outFile);
        try {
            Files.writeString(pathOut, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int getTrueKey(HashMap<Integer,Integer> countOfcoincidence){
        int maxValue = Collections.max(countOfcoincidence.keySet());
        return countOfcoincidence.get(maxValue);
    }
}
