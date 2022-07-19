package ru.javarush.cryptoanalyser.graph.constant;

import java.io.File;

public class Constants {
	//private static final String latin = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String cyrillic = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
	private static final String number = "0123456789";
	private static final String symbol = "§!@#$%ˆ&*/+-()_={}[]|<>?. ,\n";
	//public static final String ALPHABET = latin + latin.toLowerCase() + cyrillic + cyrillic.toLowerCase() + number + symbol;
	public static final String ALPHABET = cyrillic + cyrillic.toLowerCase() + number + symbol;
	
	public static final String TXT_FOLDER = System.getProperty("user.dir") +
			File.separator +
			"text" +
			File.separator;
}
