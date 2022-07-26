package ru.javarush.cryptoanalyzer.belitsky.actions;

import ru.javarush.cryptoanalyzer.belitsky.alphabet.Alphabet;
import ru.javarush.cryptoanalyzer.belitsky.myclasses.CharInt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//TODO ---  Actions2. My comment is error2 - you cannot understand it, really?
public class Actions2 {

    /**
     * @param src file source adress
     * @param dest file destination adress
     * @param key key.
     *
     * Rolls the alphabet letters with key.
     * Writes the text to destination file
     */
    public static void rollWithKey(String src, String dest, int key) {
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[5000];
            while (input.ready()) {
                int buffSize = input.read(buff);
                char[] buffToWrite = new char[buffSize];
                for (int i = 0, j = 0; i < buffSize; i++) {
                    char symbol = Character.toLowerCase(buff[i]);
                    if (Alphabet.alphabetContainsCheck(symbol))
                        buffToWrite[j++] = roll(Alphabet.indexOf(symbol), key);
                }
                finalTextWrite(dest, buffToWrite);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static char roll(int index, int key) {
        //TODO ---  need { index += Alphabet.getSize()0 }
        if (index + key < 0) index += Alphabet.getSize();
        return Alphabet.get((index + key) % Alphabet.getSize());
    }


    public static void finalTextWrite( String dest, char [] buff) {
            try (FileWriter output = new FileWriter(dest, true)) {
                    output.write(buff);
                } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @param src file source adress
     * @return key to roll the alphabet.
     * Created to find key at first 3000 symbols.
     * returns -1 if the key not found
     */
    public static int rollToCheck(String src) {
        try (FileReader input = new FileReader(src)) {
            char[] buff = new char[3000];
            int charSize = input.read(buff);
            for (int i = Alphabet.getSize() - 1; i > 0; i--) {
                boolean flag = true;
                for (int j = 0; j < charSize - 2; j++) {
                    char symbol1 = roll(Alphabet.indexOf(buff[j]), i);
                    char symbol2 = roll(Alphabet.indexOf(buff[j + 1]), i);
                    char symbol3 = roll(Alphabet.indexOf(buff[j + 2]), i);
                    if (!Actions3.pairCheck(symbol1, symbol2)) {
                        flag = false;
                        break;
                    } else if (!Actions3.trioCheck(symbol1, symbol2, symbol3)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return -1;
    }

    /**
     * @param srcOrig file source original file adress
     * @param src file source  adress
     * @return HashMap with: key = character form the encrypted source,
     * value = character from original source. key and value stats equal
     */
    public static HashMap<Character, Character> charsToChange(String srcOrig, String src) {

        try (FileReader inputOrig = new FileReader(srcOrig);
             FileReader input = new FileReader(src)) {
            ArrayList<CharInt> textOrig = Actions3.symbolsContainAnalyze(inputOrig);
            ArrayList<CharInt> text = Actions3.symbolsContainAnalyze(input);
            textOrig.sort(CharInt::compareTo);
            text.sort(CharInt::compareTo);
            HashMap<Character, Character> symbolsToChange = new HashMap<>();
            for (int i = 0; i < Math.min(textOrig.size(), text.size()); i++) {
                symbolsToChange.put(text.get(i).getSymbol(), textOrig.get(i).getSymbol());
            }
            return symbolsToChange;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
