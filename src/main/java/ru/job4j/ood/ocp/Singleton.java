package ru.job4j.ood.ocp;

public class Singleton {
    private static Singleton instance;

    //создание объекта
    private Singleton() {

    }

    public static Singleton getInstance() {
        //проверка создан объект или нет
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
