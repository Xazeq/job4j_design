package ru.job4j.ood.isp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SomeMenuTest {

    @Test
    public void whenAddMenu() {
        Item item = new Item("Меню", List.of(
                new Item("Задача 1.", List.of(
                        new Item("Задача 1.1.", new ArrayList<>(), 2),
                        new Item("Задача 1.2.", new ArrayList<>(), 2)
                ), 1),
                new Item("Задача 2.", List.of(
                        new Item("Задача 2.1.", List.of(
                                new Item("Задача 2.1.1.", new ArrayList<>(), 4)
                        ), 2)
                ), 1)), 0);
        SomeMenu someMenu = new SomeMenu();
        someMenu.addMenu(item);
        List<Item> result = someMenu.getItemList();
        assertThat(result.size(), is(7));
    }

    @Test
    public void whenSelectItemFromMenu() {
        Item item = new Item("Меню", List.of(
                new Item("Задача 1.", List.of(
                        new Item("Задача 1.1.", new ArrayList<>(), 2),
                        new Item("Задача 1.2.", new ArrayList<>(), 2)
                ), 1),
                new Item("Задача 2.", List.of(
                        new Item("Задача 2.1.", List.of(
                                new Item("Задача 2.1.1.", new ArrayList<>(), 4)
                        ), 2)
                ), 1)), 0);
        SomeMenu someMenu = new SomeMenu();
        someMenu.addMenu(item);
        Item expected = new Item("Задача 2.1.1.", new ArrayList<>(), 4);
        Item result = someMenu.select("Задача 2.1.1.");
        assertThat(result.getName(), is(expected.getName()));
    }
}