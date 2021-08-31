package ru.job4j.ood.isp;

public class Example1 {
    interface Restaurant {
        void cook();
        void serveVisitors();
        void deliverOrder();
        //Метод deliverOrder нужно будет реализовывать всегда, но не все рестораны доставляют еду
    }
}
