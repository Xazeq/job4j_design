package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        double percent = ExpireDatePercent.getPercent(food);
        if (percent < 25) {
            foods.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getFoodList() {
        return foods;
    }
}
