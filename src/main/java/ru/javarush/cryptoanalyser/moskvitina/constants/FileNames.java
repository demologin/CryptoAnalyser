package ru.javarush.cryptoanalyser.moskvitina.constants;

import ru.javarush.cryptoanalyser.moskvitina.controller.Actions;

public class FileNames {
    public static final String TEXT = "text.txt";
    public static final String ENCODED = "encoded.txt";
    public static final String DECODED = "decoded.txt";
    public static final String BRUTEFORCED = "brutforced.txt";
    public static final String KEY = "1";

    public static final String[][][] STANDARD_PARAMETERS = new String[][][]{
            {
                    {String.valueOf(Actions.ENCODE)},
                    {TEXT},
                    {ENCODED},
                    {KEY}
            },

            {
                    {String.valueOf(Actions.DECODE)},
                    {ENCODED},
                    {DECODED},
                    {KEY}
            },

            {
                    {String.valueOf(Actions.BRUTEFORCE)},
                    {ENCODED},
                    {BRUTEFORCED}
            },

    };


}
