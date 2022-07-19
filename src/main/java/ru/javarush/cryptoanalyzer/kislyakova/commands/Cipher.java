package ru.javarush.cryptoanalyzer.kislyakova.commands;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;
import ru.javarush.cryptoanalyzer.kislyakova.entity.ResultCode;
import ru.javarush.cryptoanalyzer.kislyakova.exception.AppException;
import ru.javarush.cryptoanalyzer.kislyakova.util.CreateResultFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.kislyakova.constants.CipherConstants.*;

public class Cipher implements Action{
    @Override
    public Result execute(String[] parameters) {
        Path filePath = Path.of(parameters[0]);
        int key = Integer.parseInt(parameters[1]);
        String text;
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AppException("Произошла ошибка при работе с файлом", e);
        }
        StringBuilder resultText = cipher(text, key);
        CreateResultFile.createFileWithResult(filePath, "_cipher", resultText);

        return new Result(ResultCode.OK, "Cipher");
    }

    //TODO Code style. Incorrect or unexpected order members / modifiers
    protected StringBuilder cipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            String rusCapitalLetter = RUS_CAPITAL_LETTER;
            String rusSmallLetter = RUS_SMALL_LETTER;
            String punctuation = new String(PUNCTUATION_CHAR_ARRAY);
            if (rusCapitalLetter.indexOf(character) != -1||
                    rusSmallLetter.indexOf(character) !=-1 ||
                    punctuation.indexOf(character) !=-1){
                if(Character.isUpperCase(character)){
                    result.append(findChar(rusCapitalLetter, character, key, ALPHABET_RUS_LENGTH));
                } else if(Character.isLowerCase(character)){
                    result.append(findChar(rusSmallLetter, character, key, ALPHABET_RUS_LENGTH
                    ));
                } else {
                    result.append(findChar(punctuation, character, key, PUNCTUATION_LENGTH));
                }
            } else {
                result.append(character);
            }
        }
        return result;
    }

    private Character findChar(String alphabet, char character, int key, int countLetter){
        int originalIndex = alphabet.indexOf(character);
        int newIndex = (originalIndex + key) % countLetter;
        if(newIndex >= 0){
            return alphabet.charAt(newIndex);
        } else {
            return alphabet.charAt(countLetter+newIndex);
        }
    }
}
