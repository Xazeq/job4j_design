package ru.job4j.ood.isp;

import java.util.List;

public class Item {
    private String name;
    private List<Item> itemList;

    public Item(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
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

    @Override
    public String toString() {
        return "Menu{"
                + "name='" + name + '\''
                + ", menuList=" + itemList
                + '}';
    }
}
