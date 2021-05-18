package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container = (T[]) new Object[10];
    private int size = 0;
    private int modCount = 0;

    public SimpleArray() {
    }

    public SimpleArray(int size) {
        this.container = (T[]) new Object[size];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    public void add(T model) {
        checkCapacity();
        container[size++] = model;
        modCount++;
    }

    private void checkCapacity() {
        if (size == container.length) {
            T[] temp = container;
            int newCapacity = (temp.length * 3) / 2 + 1;
            container = (T[]) new Object[newCapacity];
            System.arraycopy(temp, 0, container, 0, size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }
        };
    }
}
