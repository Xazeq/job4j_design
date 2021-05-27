package ru.job4j.collection.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count == capacity * LOAD_FACTOR) {
            expand();
        }
        MapEntry<K, V> entry = new MapEntry<>(key, value);
        int h = hash(key.hashCode());
        int index = indexFor(h);
        if (table[index] != null) {
            return false;
        }
        table[index] = entry;
        count++;
        modCount++;
        return true;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> el : oldTable) {
            if (el != null) {
                int elHash = hash(el.key.hashCode());
                table[indexFor(elHash)] = el;
            }
        }
    }

    @Override
    public V get(K key) {
        int h = hash(key.hashCode());
        int index = indexFor(h);
        if (table[index] == null) {
            return null;
        }
        if (key.equals(table[index].key)) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int h = hash(key.hashCode());
        int index = indexFor(h);
        if (table[index] == null) {
            return false;
        }
        if (key.equals(table[index].key)) {
            table[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                while (cursor < capacity && table[cursor] == null) {
                    cursor++;
                }
                return cursor < capacity;
            }

            @Override
            public V next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].value;
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleMap{"
                + "capacity=" + capacity
                + ", count=" + count
                + ", modCount=" + modCount
                + ", table=" + Arrays.toString(table)
                + '}';
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "\nMapEntry{"
                    + "key=" + key
                    + ", value=" + value
                    + '}';
        }
    }
}