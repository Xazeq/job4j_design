package ru.job4j.generics;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void whenAddUser() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        assertThat(userStore.findById("1"), is(new User("1")));
    }

    @Test
    public void whenReplaceUser() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        userStore.add(new User("3"));
        userStore.replace("2", new User("5"));
        assertThat(userStore.findById("5"), is(new User("5")));
    }

    @Test
    public void whenNotReplaceUser() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        userStore.add(new User("3"));
        assertFalse(userStore.replace("7", new User("5")));
    }

    @Test
    public void whenDeleteUser() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        userStore.add(new User("3"));
        assertTrue(userStore.delete("1"));
        assertNull(userStore.findById("1"));
    }

    @Test
    public void whenNotDeleteUser() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        assertFalse(userStore.delete("10"));
    }

    @Test
    public void whenFindUserById() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        assertThat(userStore.findById("1"), is(new User("1")));
    }

    @Test
    public void whenNotFindUserById() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1"));
        assertNull(userStore.findById("5"));
    }
}