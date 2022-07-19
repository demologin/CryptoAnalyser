package ru.javarush.cryptoanalyzer.graph.util;

import java.io.File;

public class PathFinder {
	public static String getRoot() {
		//TODO Coding. Need use private constructor in static context.
		String root = System.getProperty("user.dir");
		return root + File.separator + "text" + File.separator;
	}
}
