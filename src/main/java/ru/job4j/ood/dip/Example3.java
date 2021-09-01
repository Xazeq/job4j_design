package ru.job4j.ood.dip;

import java.util.HashMap;
import java.util.Map;

public class Example3 {
    //В данном случае в классе Tracker все заявки хранятся в памяти
    //Проблемы возникнут, если нужно будет хранить заявки в базе данных
    private static class Tracker {
        Map<Integer, Item> items = new HashMap<>();
    }

    private static class Item {

    }
}
