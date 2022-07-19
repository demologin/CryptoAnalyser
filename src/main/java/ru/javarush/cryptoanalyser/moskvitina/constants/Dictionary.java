package ru.javarush.cryptoanalyser.moskvitina.constants;

import java.util.ArrayList;

public class Dictionary {
    private static final String RUS = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String SYMBOLS = ".,”:-!? ";
    public static final char[] CHARS = (RUS + SYMBOLS).toCharArray();
    public static final ArrayList<Character> charList = new ArrayList<>();

    static{
        for (char aChar : CHARS) {
            charList.add(aChar);
        }
    }


}
