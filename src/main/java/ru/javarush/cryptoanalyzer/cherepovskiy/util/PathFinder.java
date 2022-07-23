package ru.javarush.cryptoanalyzer.cherepovskiy.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFinder {
    //TODO Coding. Need use private constructor in static context.
    public static String getRoot(){
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }


}
