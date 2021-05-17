package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        assertTrue(simpleArray.add(1));
        assertTrue(simpleArray.add(2));
        assertThat(simpleArray.get(0), is(1));
    }

    @Test
    public void whenElementNotAdded() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        simpleArray.add(1);
        assertFalse(simpleArray.add(2));
    }

    @Test
    public void whenElementReplaced() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(1, 5);
        assertThat(simpleArray.get(1), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenElementNotReplaced() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.set(4, 15);
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(3));
        assertThat(simpleArray.get(2), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNotRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.remove(2);
    }

    @Test
    public void whenGetElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNotGetElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.get(2);
    }

    @Test
    public void whenHasNextElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void whenHasNextFalse() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        Iterator<Integer> it = simpleArray.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenGetNextElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoNextElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        Iterator<Integer> it = simpleArray.iterator();
        it.next();
        it.next();
    }
}