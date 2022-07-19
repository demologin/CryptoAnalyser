package ru.javarush.cryptoanalyzer.sharifullin.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    public static boolean stringIsDecoded (String text){
        Pattern pattern1 = Pattern.compile("\\.\s");
        Pattern pattern2 = Pattern.compile("\\,\s");
        Pattern pattern3 = Pattern.compile("\s");
        Pattern pattern4 = Pattern.compile("\\.\s");

        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher3 = pattern3.matcher(text);
        Matcher matcher4 = pattern4.matcher(text);

        if (matcher1.find()==true || matcher2.find()==true || matcher3.find()==true || matcher4.find()==true){
            return true;
        } else return false;
    }
}
