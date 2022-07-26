package ru.javarush.cryptoanalyzer.rantsev.files;

import ru.javarush.cryptoanalyzer.rantsev.exception.ConsoleAppException;
import ru.javarush.cryptoanalyzer.rantsev.console.Messages;

import java.nio.file.Files;
import java.nio.file.Path;

abstract class CreatingPath {
    String reviewingPath (String console){
        Path path = Path.of(console);
        if (Files.exists(path) && !Files.isDirectory(path)) {
            Path getFileName = path.getFileName();
            console = getFileName.toString();
            return console;
        }
        throw new ConsoleAppException(Messages.PATH_NO_FIND);
    }
}
