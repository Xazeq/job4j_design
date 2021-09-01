package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;

public class SomeMenu implements Action, Print {
    private final List<Item> itemList = new ArrayList<>();

    @Override
    public void action(String name) {
        Item result = select(name);
        System.out.println("Do something");
    }

    @Override
    public void printMenu() {
        for (var item : itemList) {
            System.out.println(printLine().repeat(item.getLevel()) + item.getName());
        }
    }

    @Override
    public String printLine() {
        return "----";
    }

    public Item select(String name) {
        Item result = null;
        for (var menu : itemList) {
                if (menu.getName().equals(name)) {
                    result = menu;
                    break;
                }
           }
        return result;
    }

    public void addMenu(Item item) {
        itemList.add(item);
        for (var child : item.getMenuList()) {
            addMenu(child);
        }
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public static void main(String[] args) {
        Item item = new Item("Меню", List.of(
                new Item("Задача 1.", List.of(
                        new Item("Задача 1.1.", new ArrayList<>(), 2),
                        new Item("Задача 1.2.", new ArrayList<>(), 2)
                ), 1),
                new Item("Задача 2.", List.of(
                        new Item("Задача 2.1.", List.of(
                                new Item("Задача 2.1.1.", new ArrayList<>(), 3)
                        ), 2)
                ), 1)), 0);
        SomeMenu someMenu = new SomeMenu();
        someMenu.addMenu(item);
        someMenu.printMenu();
    }
}
