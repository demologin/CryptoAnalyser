package ru.javarush.cryptoanalyzer.sapun.util;

import java.io.File;

public class PathFinder {
    public static String getRoot(){
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" + File.separator;
    }
}