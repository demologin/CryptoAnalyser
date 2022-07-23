package ru.javarush.cryptoanalyzer.bogdanov.comands;

import ru.javarush.cryptoanalyzer.bogdanov.entity.Result;
import ru.javarush.cryptoanalyzer.bogdanov.entity.ResultCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Statistics implements Action {

    public static TreeMap<Character, Double> treeMap = new TreeMap<>();
    public static TreeMap<Character, Double> treeMap2 = new TreeMap<>();
    public static TreeMap<Character, List<Character>> treeMapStr = new TreeMap<>();
    //TODO ---  name????
    public static char[] alphubet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();


    //АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦШЩЪЫЬЭЮЯ

    //TODO Code style. Need always delete code. Not comment it.

//    //public static Path path = Paths.get("C:\\Users\\User\\IdeaProjects\\untitled22\\src\\from.txt");
//    public static Path path3 = Paths.get("C:\\Users\\User\\IdeaProjects\\untitled22\\src\\from2.txt");
//    public static Path path2 = Paths.get("C:\\Users\\User\\IdeaProjects\\untitled22\\src\\to.txt");
//    private static final byte[] bytes;
//    public static int countAllSimbols = 0;
//
//    static {
//        try {
//            bytes = Files.readAllBytes(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static final byte[] bytes2;
//
//    static {
//        try {
//            bytes2 = Files.readAllBytes(path2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static String str;
    //
    public static String str2;
    public static char[] chars;
    public static char[] chars2;

    //TODO Code style. Need always delete code. Not comment it.
    //    private static final char[] chars = str.toCharArray();
//    private static final char[] chars2 = str2.toCharArray();
    //String str = new String(bytes, StandardCharsets.UTF_8);
    public Result execute(String[] parameters) {
        //TODO Code style. Long code. Needs to be split into several methods
        Path path = Paths.get("text\\resurs.txt");
        Path path3 = Paths.get(parameters[0]);
        Path path2 = Paths.get(parameters[1]);
        byte[] bytes;
        int countAllSimbols = 0;


        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        final byte[] bytes2;


        try {
            bytes2 = Files.readAllBytes(path2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        str = new String(bytes, StandardCharsets.UTF_8);

        str2 = new String(bytes2, StandardCharsets.UTF_8);
        chars = str.toCharArray();
        chars2 = str2.toCharArray();


        countLetter(chars, treeMap);
        countLetter(chars2, treeMap2);
//        System.out.println(treeMap);
//        System.out.println(treeMap2);

        for (Map.Entry<Character, Double> chars : treeMap.entrySet()) {//первый map
            List<Character> fl = nearset(chars.getValue(), treeMap2); //получение сопостовимого или близкого символа
            treeMapStr.put(chars.getKey(), fl);
        }
        //System.out.println(treeMapStr);

        replace();
        try {
            Files.writeString(path3, str2);
            return new Result(ResultCode.OK, "Перевел");
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Ошибка");
            //throw new RuntimeException(e);
        }

    }

    public static void replace() {
        for (Map.Entry<Character, List<Character>> chars : treeMapStr.entrySet()) {
            List<Character> ch = chars.getValue();

            str2 = str2.replaceAll(String.valueOf(ch.get(0)), String.valueOf(chars.getKey()));

        }


    }


    public static void countLetter(char[] chars, Map<Character, Double> treeMap) {//частотность букв
        long count = 0;
        for (char c : alphubet) {
            double dob;
            int lenght;
            double oneProsent;
            for (char aChar : chars) {
                if ((int) c == (int) aChar) {
                    count++;

                }
            }
            if (count > 0) {

                oneProsent = chars.length / 100;//count/oneProsent
                dob = count / oneProsent;
                treeMap.put(c, dob);

                count = 0;
            }
            //System.out.println(c + "--" + dob + "%");
        }

    }

    public static List<Character> nearset(Double n, Map<Character, Double> map) {// поиск наиболее подходящего числа в другом массиве
        char nearset = ' ';
        List<Character> list = new ArrayList<>();
        double value = 2L * Integer.MAX_VALUE;
        for (Map.Entry<Character, Double> m : map.entrySet()) {
            double modul = Math.abs(n - m.getValue());
            if (value > modul) {
                value = modul;
            }


        }
        for (Map.Entry<Character, Double> m : map.entrySet()) {
            double modul = Math.abs(n - m.getValue());

            if (modul <= value + 0.02 && modul >= value - 0.02) {
                list.add(m.getKey());
            }
        }
        return list;
    }
}

