package ru.javarush.cryptoanalyzer.sharifullin.commands;


import ru.javarush.cryptoanalyzer.sharifullin.entity.Result;
import ru.javarush.cryptoanalyzer.sharifullin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.sharifullin.exception.ApplicationException;
import ru.javarush.cryptoanalyzer.sharifullin.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.sharifullin.commands.RegEx.stringIsDecoded;
import static ru.javarush.cryptoanalyzer.sharifullin.costants.Strings.ALPHABET;

public class BrutForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        String encodedFile = parameters[0];
        String decodedFile = parameters[1];
        Path pathRead = Path.of(PathFinder.getRoot() + encodedFile);
        Path pathWrite = Path.of(PathFinder.getRoot() + decodedFile);
        int code = 0;
        boolean encoded = false;
        while (encoded == false) {
            try {
                String read = Files.readString(pathRead);
                StringBuilder write = new StringBuilder();
                for (int i = 0; i < read.length(); i++) {

                    int numberofletter = ALPHABET.indexOf(read.charAt(i));
                    int deVal = (numberofletter - code) % ALPHABET.length();
                    if (deVal < 0) {
                        deVal = ALPHABET.length() + deVal;
                    }
                    char value = ALPHABET.charAt(deVal);
                    write.append(value);
                }
                if(stringIsDecoded(write.toString())==true){
                    Files.writeString(pathWrite, write.toString());
                    encoded=true;
                } else {
                    encoded=false;
                    code++;
                }


            } catch (IOException e) {
                throw new ApplicationException("IO error", e);
            }

        }
            return new Result(ResultCode.OK, "The file is encoded. Path for file " + pathWrite);

    }
}

