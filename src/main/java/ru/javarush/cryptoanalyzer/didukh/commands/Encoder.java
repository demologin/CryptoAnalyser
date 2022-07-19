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


public class Encoder implements Action{
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
            Collections.rotate(alphabetList,key);                              // смещаем ерейлист алфавита на число ключа
            char[] resultChars = new char[strings.length];                     // создаем новый массив чаров для хранения уже закодированого файла
            for(int i = 0; i < strings.length; i++){
                for (int b = 0; b < alphabet.length; b++ ){
                    int charCode1 = strings[i]; //Character.compare(strings[i],alphabetList.get(b));
                    int charCode2 = alphabet[b];
                if(charCode1 == charCode2){
                    resultChars[i] = alphabetList.get(b);
                    break;
                }
               }
            }
            StringWriter writer = new StringWriter();
            writer.write(resultChars,0, resultChars.length);
            Path pathOut = Path.of(encryptFile);
            Files.writeString(pathOut, writer.toString().trim());
        } catch (IOException e) {
            throw new ApplicationExeption("IO error",e);
        }
        return new Result(ResultCode.OK,"read all lines" + path);

    }
}
