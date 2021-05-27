package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutData() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "one"));
    }

    @Test
    public void whenNotPutData() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertFalse(map.put(1, "first"));
    }

    @Test
    public void whenGetData() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertThat(map.get(1), is("one"));
    }

    @Test
    public void whenGetNull() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertNull(map.get(2));
    }

    @Test
    public void whenIncreaseCapacityWithIntegerKey() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        assertTrue(map.put(7, "seven"));
        assertThat(map.get(3), is("three"));
        assertThat(map.get(7), is("seven"));
    }

    @Test
    public void whenIncreaseCapacityWithStringKey() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("four", 4);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("ten", 10);
        assertThat(map.get("ten"), is(10));
        assertThat(map.get("one"), is(1));
        assertThat(map.get("six"), is(6));
        map.put("eleven", 11);
        //System.out.println(map);
        assertThat(map.get("ten"), is(10));
        assertThat(map.get("one"), is(1));
        assertThat(map.get("six"), is(6));
    }

    @Test
    public void whenRemoveData() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertTrue(map.remove(1));
        assertNull(map.get(1));
    }

    @Test
    public void whenNotRemoveData() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        assertFalse(map.remove(2));
    }

    @Test
    public void whenHasNextElement() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void whenNoNextElement() {
        Map<Integer, String> map = new SimpleMap<>();
        Iterator<String> it = map.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenGetNextElement() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        Iterator<String> it = map.iterator();
        assertThat(it.next(), is("one"));
    }

    @Test
    public void whenGetSomeNextElement() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is("one"));
        assertTrue(it.hasNext());
        assertThat(it.next(), is("two"));
        assertTrue(it.hasNext());
        assertThat(it.next(), is("three"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetNextElementFromEmptyMap() {
        Map<Integer, String> map = new SimpleMap<>();
        Iterator<String> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationException() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        Iterator<String> it = map.iterator();
        map.put(2, "two");
        assertThat(it.next(), is("one"));

    }
}