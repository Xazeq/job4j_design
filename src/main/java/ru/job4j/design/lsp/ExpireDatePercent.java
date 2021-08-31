package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.Period;

public class ExpireDatePercent {
    public static double getPercent(Food food) {
        LocalDate today = LocalDate.now();
        double expirationDateInDays = Period.between(food.getExpireDate(), food.getCreateDate()).getDays();
        double daysFromCreation = Period.between(today, food.getCreateDate()).getDays();
        return (daysFromCreation / expirationDateInDays) * 100;
    }
}