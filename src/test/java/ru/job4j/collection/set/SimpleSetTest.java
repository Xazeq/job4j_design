package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenNotContains() {
        Set<Integer> set = new SimpleSet<>();
        set.add(2);
        assertFalse(set.contains(1));
    }

    @Test
    public void whenHasNextElement() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        Iterator<Integer> it = set.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void whenNoNextElement() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        Iterator<Integer> it = set.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenGetNextElement() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetNextElementFromEmptySet() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        Iterator<Integer> it = set.iterator();
        it.next();
        it.next();
    }
}