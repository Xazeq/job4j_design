package ru.job4j.collection.exam;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenAdd2Users() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"));
        List<Analize.User> curr = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Elena"),
                new Analize.User(4, "Oleg"));
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(2));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenDelete2Users() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Elena"),
                new Analize.User(4, "Oleg"));
        List<Analize.User> curr = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"));
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(2));
    }

    @Test
    public void whenChange2Users() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Elena"),
                new Analize.User(4, "Oleg"));
        List<Analize.User> curr = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Igor"),
                new Analize.User(3, "Elena"),
                new Analize.User(4, "Olga"));
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(2));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenAddAll() {
        List<Analize.User> prev = List.of();
        List<Analize.User> curr = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"));
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(2));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenDeleteAll() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"));
        List<Analize.User> curr = List.of();
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(2));
    }

    @Test
    public void whenChangeAll() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"));
        List<Analize.User> curr = List.of(
                new Analize.User(1, "Oleg"),
                new Analize.User(2, "Igor"));
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(2));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenAdd2Remove3Change1() {
        List<Analize.User> prev = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Elena"),
                new Analize.User(4, "Eugene"),
                new Analize.User(5, "Oleg"));
        List<Analize.User> curr = List.of(
                new Analize.User(2, "Vlad"),
                new Analize.User(4, "Eugene"),
                new Analize.User(6, "Semen"),
                new Analize.User(7, "Nikolay"));
        Analize.Info result = Analize.diff(prev, curr);
        assertThat(result.getAdded(), is(2));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getDeleted(), is(3));
    }
}