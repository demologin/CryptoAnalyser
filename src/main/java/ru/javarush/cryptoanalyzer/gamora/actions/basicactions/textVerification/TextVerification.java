package ru.javarush.cryptoanalyzer.gamora.actions.basicactions.textVerification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface TextVerification {
    boolean verify(String text);

    default boolean noMatch(String text, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        return !matcher.find();
    }
}
