package ru.javarush.cryptoanalyzer.letashko.commands;

import ru.javarush.cryptoanalyzer.letashko.entity.Result;

import java.util.*;


import java.util.List;

import static ru.javarush.cryptoanalyzer.letashko.contants.Strings.ALPHABET;


public class Encoder implements Action {

            public static void main(String[] args) {
                List arr = Collections.singletonList(ALPHABET);
                //TODO Coding. Magic values or methods. Bad reading and understanding
                String openText = "АПЕЛЬСИН";
                String lockedText = "ТВЧЮОДЫА";
                String test = "";
                List<String> openList = Arrays.asList(openText.split(""));  /*удаляем пробелы, если они есть, из исходной фразы*/
                int count = 0;
                for (int i = 0; i < arr.size(); i++) {
                    ListIterator<String> listIter = openList.listIterator();
                    //TODO Code style. Many warnings. Skip or fix it.
                    while (listIter.hasNext()) {
                        String k = listIter.next();
                        //TODO Code style. Many warnings. Skip or fix it.
                        if ((arr.indexOf(k.charAt(0)) + count) < arr.size()) {
                            test += arr.get(arr.indexOf(k.charAt(0)) + count);
                        } else {
                            test += arr.get((arr.indexOf(k.charAt(0)) + count) - arr.size());
                        }
                    }
                    if (test.equals(lockedText)) {
                        System.out.println(count);
                        break;
                    } else {
                        test ="";
                        count++;
                    }
                }

            }

    @Override
    public Result execute(String[] parameters) {
        return null;
    }
}
