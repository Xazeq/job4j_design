package ru.job4j.ood.isp;

public class Example2 {
    interface Bird {
        void eat();
        void sleep();
        void fly();
        //Метод fly здесь лишний т.к. не все птицы умеют летать
    }
}
