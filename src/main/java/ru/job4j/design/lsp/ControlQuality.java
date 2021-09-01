package ru.job4j.design.lsp;

import java.util.ArrayList;
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

    public void resort() {
        List<Food> allFood = new ArrayList<>();
        for (var store : stores) {
            allFood.addAll(store.getFoodList());
            store.getFoodList().clear();
        }
        for (var food : allFood) {
            reallocate(food);
        }
    }
}
