package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Example1 {

    private interface OfficeEmployees {
        //В данном случае поле, параметр конструктора и тип возвращаемого значения
        //метода findEmployees это реализованный класс, а не абстракция
        //Проблемы возникнут, если я захочу использовать LinkedList для хранения работников
        ArrayList<String> findEmployees(Predicate<String> predicate);
    }

    private static class NewOfficeEmployees implements OfficeEmployees {
        ArrayList<String> employees;

        public NewOfficeEmployees(ArrayList<String> employees) {
            this.employees = employees;
        }

        @Override
        public ArrayList<String> findEmployees(Predicate<String> predicate) {
            ArrayList<String> result = new ArrayList<>();
            for (var emp : employees) {
                if (predicate.test(emp)) {
                    result.add(emp);
                }
            }
            return result;
        }
    }
}
