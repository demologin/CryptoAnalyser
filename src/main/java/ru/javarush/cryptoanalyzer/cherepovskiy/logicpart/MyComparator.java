package ru.javarush.cryptoanalyzer.cherepovskiy.logicpart;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class MyComparator implements Comparator<Object> {
    //сортировка мапы по значению
    Map<Character, Integer> map;

    public MyComparator(Map<Character, Integer> map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        if (Objects.equals(map.get(o2), map.get(o1)))
            return 1;
        else
            return map.get(o2).compareTo(map.get(o1));
    }
}
