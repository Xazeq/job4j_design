package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] data;
    private int count = 0;

    public SimpleArray(int size) {
        data = (T[]) new Object[size];
    }

    public boolean add(T model) {
        if (count < data.length) {
            data[count++] = model;
            return true;
        }
        return false;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(data, index + 1, data, index, count - index - 1);
        data[count - 1] = null;
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[cursor++];
            }
        };
    }
}