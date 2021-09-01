package ru.job4j.ood.dip;

public class Example1 {
    //Класс UserInput использует класс ConsoleScanner для считывания текста из консоли
    //Получается что класс UserInput зависит от ConsoleScanner
    //В данном случае нужно создать интерфейс Scanner и использовать его
    private static class UserInput {
        private String input;
        private ConsoleScanner scanner = new ConsoleScanner();

        public UserInput(String input) {
            this.input = input;
        }

        public void scan() {
            input = scanner.scan();
        }
    }

    private static class ConsoleScanner {
        public String scan() {
            return null;
        }
    }
}
