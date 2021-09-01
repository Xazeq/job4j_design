package ru.job4j.ood.lsp;

public class Car implements Transport {
    private int size = 1;

    @Override
    public int getSize() {
        return size;
    }
}
