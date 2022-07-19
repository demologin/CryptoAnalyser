package ru.javarush.cryptoanalyzer.marzhiievskyi.util;

import java.io.File;

public class PathFinder {
    //TODO Coding. Need use private constructor in static context.
    public static String getRoot() {
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }
}
