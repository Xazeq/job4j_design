package ru.job4j.ood.isp;

public class Example3 {
    interface Airplane {
        void drive();
        void fly();
        void landOnWater();
        //Метод landOnWater лишний т.к. не все самолеты могут садиться на воду
    }
}
