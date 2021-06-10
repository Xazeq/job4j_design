package ru.job4j.collection.exam;

import java.util.*;

public class Email {
    public static Map<String, Set<String>> merge(Map<String, Set<String>> source) {
        Map<String, Set<String>> result = new HashMap<>();
        for (Map.Entry<String, Set<String>> sourceEntry : source.entrySet()) {
            if (result.isEmpty()) {
                result.put(sourceEntry.getKey(), sourceEntry.getValue());
                continue;
            }
            Set<String> set = new HashSet<>();
            String key = sourceEntry.getKey();
            for (Map.Entry<String, Set<String>> resultEntry : result.entrySet()) {
                if (!Collections.disjoint(sourceEntry.getValue(), resultEntry.getValue())) {
                    result.get(resultEntry.getKey()).addAll(sourceEntry.getValue());
                    key = resultEntry.getKey();
                    break;
                } else {
                    set.addAll(sourceEntry.getValue());
                }
            }
            if (set.size() == sourceEntry.getValue().size()) {
                result.put(key, set);
            }
        }
        return result;
    }
}