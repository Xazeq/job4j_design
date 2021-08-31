package ru.job4j.ood.lsp;

public class Example1 {
    private static class Bank {
        public boolean transferMoney(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Сумма перевода должны быть больше нуля");
            }
            return true;
        }
    }

    private static class SomeBank extends Bank {
        @Override
        public boolean transferMoney(int amount) {
            if (amount < 5000) {
                throw new IllegalArgumentException("Сумма перевода должны быть от 5000");
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Bank bank = new SomeBank();
        bank.transferMoney(500);
    }
}
