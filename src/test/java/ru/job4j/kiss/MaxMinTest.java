package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenFindMaxNumber() {
        MaxMin maxMin = new MaxMin();
        List<Integer> numbers = List.of(2, 64, 0, -23, 432, 12, 32, 123);
        Integer expected = 432;
        assertThat(maxMin.max(numbers, Comparator.comparingInt(x -> x)), is(expected));
    }

    @Test
    public void whenFindMinNumber() {
        MaxMin maxMin = new MaxMin();
        List<Integer> numbers = List.of(2, 64, 0, -23, 432, 12, 32, 123);
        Integer expected = -23;
        assertThat(maxMin.min(numbers, Comparator.comparingInt(x -> x)), is(expected));
    }

    @Test
    public void whenEmptyList() {
        MaxMin maxMin = new MaxMin();
        List<Integer> numbers = new ArrayList<>();
        assertNull(maxMin.max(numbers, Comparator.comparingInt(x -> x)));
    }

    @Test
    public void whenFindMaxString() {
        MaxMin maxMin = new MaxMin();
        List<String> numbers = List.of("a", "213", "123abc", "dfe", "hello");
        String expected = "123abc";
        assertThat(maxMin.max(numbers, Comparator.comparingInt(String::length)), is(expected));
    }

    @Test
    public void whenFindMinString() {
        MaxMin maxMin = new MaxMin();
        List<String> numbers = List.of("a", "213", "123abc", "dfe", "hello");
        String expected = "a";
        assertThat(maxMin.min(numbers, Comparator.comparingInt(String::length)), is(expected));
    }
}