package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                char c = s.charAt(0);
                if (c <= 'A' || c >= 'Z') {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> resultList = new ArrayList<>();
            for (String s : values) {
                boolean moreThan2Words = s.split(" ").length > 3;
                boolean startWithUpperCase = s.charAt(0) >= 'A' && s.charAt(0) <= 'Z';
                boolean lastCharIsDot = s.endsWith(".");
                if (moreThan2Words && startWithUpperCase && lastCharIsDot) {
                    resultList.add(s);
                }
            }
            return resultList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> resultMap = new HashMap<>();
            for (String s : x) {
                resultMap.put(s, s.length());
            }
            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> resultList = new ArrayList<>(list1);
            resultList.addAll(list2);
            return resultList;
        };
    }
}
