package ru.job4j.generics;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        assertThat(roleStore.findById("1"), is(new Role("1")));
    }

    @Test
    public void whenReplaceUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        roleStore.add(new Role("3"));
        roleStore.replace("2", new Role("5"));
        assertThat(roleStore.findById("5"), is(new Role("5")));
    }

    @Test
    public void whenNotReplaceUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        roleStore.add(new Role("3"));
        assertFalse(roleStore.replace("7", new Role("5")));
    }

    @Test
    public void whenDeleteUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        roleStore.add(new Role("3"));
        assertTrue(roleStore.delete("1"));
        assertNull(roleStore.findById("1"));
    }

    @Test
    public void whenNotDeleteUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        assertFalse(roleStore.delete("10"));
    }

    @Test
    public void whenFindUserById() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        assertThat(roleStore.findById("1"), is(new Role("1")));
    }

    @Test
    public void whenNotFindUserById() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        assertNull(roleStore.findById("5"));
    }
}