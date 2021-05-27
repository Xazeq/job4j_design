package ru.job4j.hashcode;

import java.util.Objects;

public class Person {
    String name;
    String surname;
    int age;
    int children;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age
                && children == person.children
                && Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + Integer.hashCode(age);
        result = 31 * result + Integer.hashCode(children);
        return result;
    }
}
