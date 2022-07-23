package ru.javarush.cryptoanalyzer.cherepovskiy.logicpart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForceCheck {
    public static Boolean encryptCorrect = false;
    //    проверка на коректность расшифровки по запятой и пробелу
    public static void encryptIsTrue(String str) {
        int count = 0;
        Pattern pattern = Pattern.compile("(,\s)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            count++;
        }
        if (count > 5) {
            encryptCorrect = true;
        }
    }
}
