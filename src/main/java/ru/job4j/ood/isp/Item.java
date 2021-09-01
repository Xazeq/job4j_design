package ru.job4j.ood.isp;

import java.util.List;

public class Item {
    private String name;
    private List<Item> itemList;
    private int level;

    public Item(String name, List<Item> itemList, int level) {
        this.name = name;
        this.itemList = itemList;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getMenuList() {
        return itemList;
    }

    public void setMenuList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Menu{"
                + "name='" + name + '\''
                + ", menuList=" + itemList
                + '}';
    }
}
