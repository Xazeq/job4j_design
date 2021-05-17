package ru.job4j.generics;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {

    @Test
    public void whenAddUser() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        assertThat(memStore.findById("1"), is(new User("1")));
    }

    @Test
    public void whenReplaceUser() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        memStore.add(new User("2"));
        memStore.add(new User("3"));
        memStore.replace("2", new User("5"));
        assertThat(memStore.findById("5"), is(new User("5")));
    }

    @Test
    public void whenNotReplaceUser() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        memStore.add(new User("2"));
        memStore.add(new User("3"));
        assertFalse(memStore.replace("7", new User("5")));
    }

    @Test
    public void whenDeleteUser() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        memStore.add(new User("2"));
        memStore.add(new User("3"));
        assertTrue(memStore.delete("1"));
        assertNull(memStore.findById("1"));
    }

    @Test
    public void whenNotDeleteUser() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        memStore.add(new User("2"));
        assertFalse(memStore.delete("10"));
    }

    @Test
    public void whenFindUserById() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        assertThat(memStore.findById("1"), is(new User("1")));
    }

    @Test
    public void whenNotFindUserById() {
        MemStore<User> memStore = new MemStore<>();
        memStore.add(new User("1"));
        assertNull(memStore.findById("5"));
    }
}