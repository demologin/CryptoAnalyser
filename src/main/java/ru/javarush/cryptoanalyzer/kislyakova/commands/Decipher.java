package ru.javarush.cryptoanalyzer.kislyakova.commands;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;
import ru.javarush.cryptoanalyzer.kislyakova.entity.ResultCode;
import ru.javarush.cryptoanalyzer.kislyakova.exception.AppException;
import ru.javarush.cryptoanalyzer.kislyakova.util.CreateResultFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decipher implements Action{
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
        StringBuilder resultText = decipher(text, key);
        CreateResultFile.createFileWithResult(filePath, "_decipher", resultText);
        return new Result(ResultCode.OK, "Decipher");
    }

    protected StringBuilder decipher(String text, int key) {
        Cipher cipher = new Cipher();
        return cipher.cipher(text, -key);
    }
}
