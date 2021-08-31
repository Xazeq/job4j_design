package ru.job4j.ood.lsp;

public class Example3 {
    private static class Converter {
        public int convertRubToEuro(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма должна быть больше нуля");
            }
            int result = amount * 83;
            if (result > 0) {
                return result;
            }
            throw new IllegalArgumentException();
        }
    }

    private static class SomeConverter extends Converter {
        @Override
        public int convertRubToEuro(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма должна быть больше нуля");
            }
            return amount * 83;
        }
    }
}
