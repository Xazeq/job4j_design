package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int inCount = 0;
    int outCount = 0;

    public T poll() {
        if (outCount == 0) {
            while (outCount < inCount) {
                out.push(in.pop());
                outCount++;
            }
            inCount = 0;
            outCount--;
            return out.pop();
        }
        outCount--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inCount++;
    }
}
