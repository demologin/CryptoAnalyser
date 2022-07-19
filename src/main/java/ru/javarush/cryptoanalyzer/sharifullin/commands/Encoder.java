package ru.javarush.cryptoanalyzer.sharifullin.commands;


import ru.javarush.cryptoanalyzer.sharifullin.entity.Result;
import ru.javarush.cryptoanalyzer.sharifullin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.sharifullin.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.sharifullin.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.sharifullin.costants.Strings.ALPHABET;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String txtFile = parameters[0];
        String encryptedFile = parameters[1];
        int code = Integer.parseInt(parameters[2]);
        Path pathRead = Path.of(PathFinder.getRoot() + txtFile);
        Path pathWrite = Path.of(PathFinder.getRoot() + encryptedFile);
        try {
            String read = Files.readString(pathRead);
            StringBuilder write = new StringBuilder();
            for (int i = 0; i < read.length(); i++) {
                int numberofletter = ALPHABET.indexOf(read.charAt(i));
                int enVal = (code + numberofletter) % ALPHABET.length();
                char value = ALPHABET.charAt(enVal);
                write.append(value);
            }
            Files.writeString(pathWrite, write.toString());
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCode.OK, "The file is encoded. Path for file " + pathWrite);
    }
}
