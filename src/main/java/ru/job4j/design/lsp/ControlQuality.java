package ru.job4j.design.lsp;

import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void reallocate(Food food) {
        for (var store : stores) {
            store.add(food);
        }
    }
}
