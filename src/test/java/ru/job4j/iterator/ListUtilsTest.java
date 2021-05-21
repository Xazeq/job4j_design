package ru.job4j.iterator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.core.Is;
import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfterFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 0, 5);
        assertThat(Arrays.asList(0, 5, 1, 2), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterInEmptyList() {
        List<Integer> input = new ArrayList<>();
        ListUtils.addAfter(input, 1, 5);
    }

    @Test
    public void whenRemoveIfMoreThenTwo() {
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 0, 3, 1));
        ListUtils.removeIf(input, el -> el > 2);
        assertThat(List.of(2, 1, 0, 1), Is.is(input));
    }

    @Test
    public void whenReplaceIfLessThenZero() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-3, 9, -1, 5, 0, -3, 4));
        ListUtils.replaceIf(input, el -> el < 2, 0);
        assertThat(List.of(0, 9, 0, 5, 0, 0, 4), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> remove = List.of(2, 4, 6, 8);
        ListUtils.removeAll(input, remove);
        assertThat(List.of(1, 3, 5, 7, 9), Is.is(input));
    }
}