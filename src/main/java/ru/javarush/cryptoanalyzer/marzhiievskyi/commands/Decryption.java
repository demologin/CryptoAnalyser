package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.ArgsException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.util.PathFinder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Decryption extends DecryptingKeyShift implements Action {
    @Override
    public Result execute(String[] parameters) {
        String inputTextFile = parameters[0];
        String decryptedTextFile = parameters[1];

        List<Character> textCharsList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputTextFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile))) {

            int keyShift = Integer.parseInt(parameters[2]);
            while (bufferedReader.ready()) {
                textCharsList.add((char) bufferedReader.read());
            }

            for (Character character : textCharsList) {
                bufferedWriter.write(decryptingByKeyShift(character, keyShift));
            }
            //TODO Code style. Needs reformat or extraction to methods / variables / constants
            return new Result(ResultCode.OK, "Расшифрование завершено. \nПуть к результату: " + PathFinder.getRoot() + decryptedTextFile);


        } catch (IOException e) {
            throw new AppException(Strings.IO_EXCEPTION_MSG, e);
        } catch (NumberFormatException e) {
            throw new ArgsException(Strings.ARGS_EXCEPTION_MSG, e);
        }
    }
}
