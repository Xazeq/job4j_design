package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getMaxOrMin(value, comparator, predicate -> predicate < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getMaxOrMin(value, comparator, predicate -> predicate > 0);
    }

    private <T> T getMaxOrMin(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        if (value.size() == 0) {
            return null;
        }
        T result = value.get(0);
        for (var element : value) {
            if (predicate.test(comparator.compare(result, element))) {
                result = element;
            }
        }
        return result;
    }
}
