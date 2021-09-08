package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;

public class SomeMenu implements Print {
    private final List<Item> itemList = new ArrayList<>();

    public void select(Action action, String name) {
        Item result = getItemByName(name);
        action.action(result);
    }

    @Override
    public void printMenu(Item item, String line) {
        System.out.println(item.getName());
        for (var child : item.getMenuList()) {
            System.out.print(line);
            printMenu(child, line + line);
        }
    }

    @Override
    public String printLine() {
        return "----";
    }

    public Item getItemByName(String name) {
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
                        new Item("Задача 1.1.", new ArrayList<>()),
                        new Item("Задача 1.2.", new ArrayList<>())
                )),
                new Item("Задача 2.", List.of(
                        new Item("Задача 2.1.", List.of(
                                new Item("Задача 2.1.1.", new ArrayList<>())
                        ))
                ))));
        SomeMenu someMenu = new SomeMenu();
        someMenu.addMenu(item);
        someMenu.printMenu(someMenu.getItemList().get(0), someMenu.printLine());
    }
}
