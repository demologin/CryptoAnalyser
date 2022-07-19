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

public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        String txtFile = parameters[0];
        String encryptFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        Path path = Path.of(PathFinder.getRoot() + txtFile);
        try {
            char[] strings = Files.readAllLines(path).toString().toCharArray();// массив чаров файла
            char[] alphabet = Strings.ALPHABET.toCharArray();                  // массив алфавита

            ArrayList<Character> alphabetList = new ArrayList<>();             // ерейлист алфавита
            for (char c : alphabet) {
                alphabetList.add(c);                                 // заполняем ерейлист алфавита
            }
            Collections.rotate(alphabetList,(Math.abs(key - alphabet.length)));                              // смещаем ерейлист алфавита на число ключа
            char[] resultChars = decode(strings,alphabet,alphabetList);             // создаем новый массив чаров для хранения уже разкодированого текста в чарах
            writeDecoderedText(encryptFile,resultChars);
        } catch (IOException e) {
            throw new ApplicationExeption("IO error",e);
        }
        return new Result(ResultCode.OK,"read all lines" + path);
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
}

