package ru.javarush.cryptoanalyzer.tretyakova.util;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    public static final Map<Character, Integer> encryptMap = new HashMap<>();
    public static final Map<Integer, Character> decryptMap = new HashMap<>();

    private Alphabet() {
    }

    static {
        //TODO ---  bad code. What can I do if I have 5000 symbols?
        encryptMap.put('а', 0);
        encryptMap.put('б', 1);
        encryptMap.put('в', 2);
        encryptMap.put('г', 3);
        encryptMap.put('д', 4);
        encryptMap.put('е', 5);
        encryptMap.put('ё', 6);
        encryptMap.put('ж', 7);
        encryptMap.put('з', 8);
        encryptMap.put('и', 9);
        encryptMap.put('й', 10);
        encryptMap.put('к', 11);
        encryptMap.put('л', 12);
        encryptMap.put('м', 13);
        encryptMap.put('н', 14);
        encryptMap.put('о', 15);
        encryptMap.put('п', 16);
        encryptMap.put('р', 17);
        encryptMap.put('с', 18);
        encryptMap.put('т', 19);
        encryptMap.put('у', 20);
        encryptMap.put('ф', 21);
        encryptMap.put('х', 22);
        encryptMap.put('ц', 23);
        encryptMap.put('ч', 24);
        encryptMap.put('ш', 25);
        encryptMap.put('щ', 26);
        encryptMap.put('ъ', 27);
        encryptMap.put('ы', 28);
        encryptMap.put('ь', 29);
        encryptMap.put('э', 30);
        encryptMap.put('ю', 31);
        encryptMap.put('я', 32);
        encryptMap.put(' ', 33);
        encryptMap.put('.', 34);
        encryptMap.put(',', 35);
        encryptMap.put('(', 36);
        encryptMap.put(')', 37);
        encryptMap.put(':', 38);
        encryptMap.put('"', 39);
        encryptMap.put('!', 40);
        encryptMap.put('«', 41);
        encryptMap.put('»', 42);
        encryptMap.put('?', 43);
        encryptMap.put(';', 44);
        encryptMap.put('-', 45);
        encryptMap.put('0', 46);
        encryptMap.put('1', 47);
        encryptMap.put('2', 48);
        encryptMap.put('3', 49);
        encryptMap.put('4', 50);
        encryptMap.put('5', 51);
        encryptMap.put('6', 52);
        encryptMap.put('7', 53);
        encryptMap.put('8', 54);
        encryptMap.put('9', 55);
        encryptMap.put('–', 56);

        //TODO ---  duplicate code (maybe it can to fill from previous map)
        decryptMap.put(0, 'а');
        decryptMap.put(1, 'б');
        decryptMap.put(2, 'в');
        decryptMap.put(3, 'г');
        decryptMap.put(4, 'д');
        decryptMap.put(5, 'е');
        decryptMap.put(6, 'ё');
        decryptMap.put(7, 'ж');
        decryptMap.put(8, 'з');
        decryptMap.put(9, 'и');
        decryptMap.put(10, 'й');
        decryptMap.put(11, 'к');
        decryptMap.put(12, 'л');
        decryptMap.put(13, 'м');
        decryptMap.put(14, 'н');
        decryptMap.put(15, 'о');
        decryptMap.put(16, 'п');
        decryptMap.put(17, 'р');
        decryptMap.put(18, 'с');
        decryptMap.put(19, 'т');
        decryptMap.put(20, 'у');
        decryptMap.put(21, 'ф');
        decryptMap.put(22, 'х');
        decryptMap.put(23, 'ц');
        decryptMap.put(24, 'ч');
        decryptMap.put(25, 'ш');
        decryptMap.put(26, 'щ');
        decryptMap.put(27, 'ъ');
        decryptMap.put(28, 'ы');
        decryptMap.put(29, 'ь');
        decryptMap.put(30, 'э');
        decryptMap.put(31, 'ю');
        decryptMap.put(32, 'я');
        decryptMap.put(33, ' ');
        decryptMap.put(34, '.');
        decryptMap.put(35, ',');
        decryptMap.put(36, '(');
        decryptMap.put(37, ')');
        decryptMap.put(38, ':');
        decryptMap.put(39, '"');
        decryptMap.put(40, '!');
        decryptMap.put(41, '«');
        decryptMap.put(42, '»');
        decryptMap.put(43, '?');
        decryptMap.put(44, ';');
        decryptMap.put(45, '-');
        decryptMap.put(46, '0');
        decryptMap.put(47, '1');
        decryptMap.put(48, '2');
        decryptMap.put(49, '3');
        decryptMap.put(50, '4');
        decryptMap.put(51, '5');
        decryptMap.put(52, '6');
        decryptMap.put(53, '7');
        decryptMap.put(54, '8');
        decryptMap.put(55, '9');
        decryptMap.put(56, '–');
    }
}
