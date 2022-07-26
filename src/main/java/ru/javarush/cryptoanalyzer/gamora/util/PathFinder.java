package ru.javarush.cryptoanalyzer.gamora.util;

import ru.javarush.cryptoanalyzer.gamora.exception.CryptoanalyzerApplicationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathFinder {

    public static PathFinder pathFinder;

    static {
        pathFinder = new PathFinder();
    }

    private PathFinder() {
    }

    private Path getRoot() {
        String root = System.getProperty("user.dir");
        String textsPath = root + File.separator + "text" + File.separator;
        return Path.of(textsPath);
    }

    /*
    Если путь к файлу абсолютный, вернём его.
    Если относительный, будем считать, что он лежит в папке user.dir/text
     */
    public Path getFilePath(String[] args, int argIndex) {
        String pathString = args[argIndex];
        Path path = Path.of(pathString);

        if (path.isAbsolute()) {
            return path;
        } else {
            Path root = getRoot();
            path = root.resolve(path);
        }

        return path;
    }

    /*
    Если путь к файлу абсолютный, вернём его.
    Если относительный, будем считать, что он лежит в папке user.dir/text
     */
    public Path getFilePath(String pathString) {
        Path path = Path.of(pathString);

        if (path.isAbsolute()) {
            return path;
        } else {
            Path root = getRoot();
            path = root.resolve(path);
        }

        return path;
    }
}
