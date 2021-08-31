package ru.job4j.ood.ocp;

public class Example2 {

    private static class Cook {
        private String name;

        public Cook(String name) {
            this.name = name;
        }

        public void makeBreakfast() {
            System.out.println("Повар делает завтрак");
        }
    }
}
