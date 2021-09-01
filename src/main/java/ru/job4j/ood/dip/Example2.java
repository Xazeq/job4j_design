package ru.job4j.ood.dip;

import java.time.LocalDate;

public class Example2 {
    //В данном случае у человека есть водительское удостоверение категории B
    //Возникнут сложности, если он откроет еще категорию A
    private static class Human {
        private String name;
        private DriverLicenseCategoryB license;

        public Human(String name, DriverLicenseCategoryB license) {
            this.name = name;
            this.license = license;
        }
    }

    private static class DriverLicenseCategoryB {
        private LocalDate createDate;
        private LocalDate expireDate;

        public DriverLicenseCategoryB(LocalDate createDate, LocalDate expireDate) {
            this.createDate = createDate;
            this.expireDate = expireDate;
        }

        public void prolong() {
            expireDate = expireDate.plusYears(5);
        }
    }
}
