package ru.javarush.cryptoanalyzer.didukh.commands;

import ru.javarush.cryptoanalyzer.didukh.constans.Strings;
import ru.javarush.cryptoanalyzer.didukh.entity.Result;
import ru.javarush.cryptoanalyzer.didukh.entity.ResultCode;
import ru.javarush.cryptoanalyzer.didukh.exeption.ApplicationExeption;
import ru.javarush.cryptoanalyzer.didukh.util.PathFinder;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Statistic implements Action{

    @Override
    public Result execute(String[] parameters) {
        //TODO Code style. Long code. Needs to be split into several methods
        String txtFile = parameters[0];
        String encryptFile = parameters[1];
        String exampleFile = parameters[2];

        Path path = Path.of(PathFinder.getRoot() + txtFile);
        Path path2 = Path.of(PathFinder.getRoot() + exampleFile);


        try {
            char[] codedTextInCharArray = Files.readAllLines(path).toString().toCharArray();
            char[] exampleTextInCharArray = Files.readAllLines(path2).toString().toCharArray();
            char[] alphabetInCharArray = Strings.ALPHABET.toCharArray();
            HashMap<Double,Character> txtFileStatistics = new HashMap<>();
            HashMap<Double,Character> exampleFileStatistics = new HashMap<>();
            putStatistics(codedTextInCharArray,alphabetInCharArray,txtFileStatistics);
            putStatistics(exampleTextInCharArray,alphabetInCharArray,exampleFileStatistics);

              double maxValueOfLetterTextFile = Collections.max(txtFileStatistics.keySet());            // максимальний коєфіцієнт повторення символа з тексту
            double maxValueOfLetterExampleFile = Collections.max(exampleFileStatistics.keySet());     // максимальний коєфіцієнт повторення символа з тексту-прикладу

            char textPopularSymbol = txtFileStatistics.get(maxValueOfLetterTextFile);                //дістаємо найпопулярніший символ закодованого тексту
            char examplePopularSymbol = exampleFileStatistics.get(maxValueOfLetterExampleFile);      //дістаємо найпопулярніший символ тексту-прикладу

            int textIndexOfSymbolInAlphabet = getSymbolIndex(alphabetInCharArray,textPopularSymbol);        // індекс символа з тексту в масиві алфавіту
            int exampleIndexOfSymbolInAlphabet = getSymbolIndex(alphabetInCharArray,examplePopularSymbol);  // індекс символа з текста-приклада в масиві алфавіту
            // тепер мені треба дізнатися різницю між індексами, так би мовити ключ
            int key = Math.max(textIndexOfSymbolInAlphabet, exampleIndexOfSymbolInAlphabet) - Math.min(textIndexOfSymbolInAlphabet, exampleIndexOfSymbolInAlphabet);

            ArrayList<Character> alphabetList = new ArrayList<>();             // ерейлист алфавита
            for (char c : alphabetInCharArray) {
                alphabetList.add(c);                                 // заполняем ерейлист алфавита
            }
            Collections.rotate(alphabetList,(Math.abs(key - alphabetInCharArray.length)));        // смещаем ерейлист алфавита на число ключа
            char[] resultChars = decode(codedTextInCharArray,alphabetInCharArray,alphabetList);  // создаем новый массив чаров для хранения уже разкодированого текста в чарах
            writeDecoderedText(encryptFile,resultChars);
        } catch (IOException e) {
            throw new ApplicationExeption("IO error",e);
        }
        return new Result(ResultCode.OK,"read all lines" + path);
    }


    private static int getSymbolIndex (char[] symbolArray, char symbol){
        int symbolIndex = 0;
        for (int i = 0; i < symbolArray.length; i++){
            int symbolCode1 = symbolArray[i];
            if(symbolCode1== (int) symbol){
                symbolIndex = i;
            }
        }
        return symbolIndex;
    }

    char[] decode(char[] strings, char[] alphabet, ArrayList<Character> alphabetList){
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

    void writeDecoderedText(String outFile, char[] resultChars){
        StringWriter writer = new StringWriter();
        writer.write(resultChars, 0, resultChars.length);
        Path pathOut = Path.of(outFile);
        try {
            Files.writeString(pathOut, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void putStatistics(char[] symbols, char[] alphabet,HashMap<Double,Character> statistics){
        for (char value : alphabet) {
            int count = 0;
            int textCharCode;
            for (char c : symbols) {
                textCharCode = c;
                if ((int) value == textCharCode) {
                    count++;
                }

            }
            double coeficient = (count*1000) / symbols.length;

            statistics.put(coeficient, value);           // в значення записуємо символ а в ключ коєфіцієнт його повторень в тексті
        }
    }
}
