package ru.javarush.cryptoanalyzer.belitsky.actions;

import ru.javarush.cryptoanalyzer.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanalyzer.belitsky.myclasses.CharInt;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Actions3 {

    public static boolean pairCheck(char symbol1, char symbol2) {
        if (Alphabet.symbolsToCheckContainCheck(symbol1) && symbol2 != ' ') return false;
        else return !Alphabet.symbolsContainCheck(symbol1) || !Alphabet.symbolsContainCheck(symbol2);
    }

    public static boolean trioCheck(char symbol1, char symbol2, char symbol3) {
        return !(symbol1 == ' ' && Alphabet.yodle(symbol2) && Alphabet.lettersContainCheck(symbol3));
    }


    /**
     * @param input stream of chars
     * @return ArrayList of CharInt - with pair (symbol,his quantity at text)
     */
    public static ArrayList<CharInt> symbolsContainAnalyze(FileReader input) throws IOException {
        char[] buff = new char[5000];
        ArrayList<CharInt> symbolList = new ArrayList<>();
            while (input.ready()) {
                int buffSize = input.read(buff);
                for (int i = 0; i < buffSize; i++) {
                    char symbol = Character.toLowerCase(buff[i]);
                    if (!Alphabet.alphabetContainsCheck(symbol)) continue;
                    CharInt charInt = new CharInt(symbol, 1);
                    if (symbolList.contains(charInt)) {
                        int index = symbolList.indexOf(charInt);
                        charInt.setSymbolQuantity(symbolList.get(index).getSymbolQuantity() + 1);
                        symbolList.set(index, charInt);
                    } else symbolList.add(charInt);
                }
            }
        return symbolList;

    }

    public static boolean isNumber(String choise) {
        //TODO Coding. Magic values or methods. Bad reading and understanding
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(choise);
        return !matcher.find();
    }
}
