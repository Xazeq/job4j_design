package ru.job4j.ood.lsp;

public class Example2 {
    private static class Animal {

    }

    private static class Dog extends Animal {

    }

    private static class Cat extends Animal {

    }

    public static void main(String[] args) {
        Animal animal = new Cat();
        if (animal.getClass() == Dog.class) {
            System.out.println("Купить корм для собак");
        } else if (animal.getClass() == Cat.class) {
            System.out.println("Купить корм для котов");
        }
    }
}
