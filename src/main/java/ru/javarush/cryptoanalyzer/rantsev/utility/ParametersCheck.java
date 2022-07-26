package ru.javarush.cryptoanalyzer.rantsev.utility;

import ru.javarush.cryptoanalyzer.rantsev.exception.ConsoleAppException;
import ru.javarush.cryptoanalyzer.rantsev.console.Menu;
import static ru.javarush.cryptoanalyzer.rantsev.console.Messages.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ParametersCheck {
    String root = PathFinder.getRoot();
    public String[] checkArgs(String[] args) {
        //We call our list of commands to check from the Menu class
        Menu.addCommands();
        Map<Integer, String> commands = Menu.getCommands();
        String[] verifiedArgs = new String[commands.size() - 1];
        for (int i = 0; i < commands.size() - 1; i++) {
            if (args[0].equals(commands.get(i))) {
                verifiedArgs[0] = args[0];
                break;
            } else if (args[0].equals(commands.get(4))) {
                System.exit(0);
            } else {
                throw new ConsoleAppException(ERROR_COMMAND);
            }
        }
        if (checkFiles(args[1]) && checkFiles(args[2])) {
            verifiedArgs[1] = args[1];
            verifiedArgs[2] = args[2];
        } else {
            throw new ConsoleAppException(FILE_NO_FIND);
        }
        if (checkKey(args[3])) {
            verifiedArgs[3] = args[3];
        } else {
            throw new ConsoleAppException(KEY_ERROR);
        }
        return verifiedArgs;
    }

    boolean checkFiles(String args) {
        Path path = Path.of(args);
        if (Files.exists(Path.of(root + path)) && !Files.isDirectory(Path.of(root + path))) {
            return true;
        } else {
            throw new ConsoleAppException(FILE_NO_FIND);
        }
    }
    boolean checkKey(String args) {
            int keyInt = Integer.parseInt(args);
            return keyInt > 1;
    }
}
