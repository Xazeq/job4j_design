package ru.job4j.ood.ocp;

public class Example3 {

    private static class Converter {
        //В данном случае для если понадобится перевести рубли в доллары
        //то потребеутся создавать еще один метод
        public int convertRubleToEuro(int amount) {
            return amount * 86;
        }
    }
}
