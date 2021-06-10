package ru.job4j.collection.exam;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class EmailTest {

    @Test
    public void whenMerge() {
        Map<String, Set<String>> input = new HashMap<>();
        Set<String> user1 = new HashSet<>();
        user1.add("xxx@ya.ru");
        user1.add("foo@gmail.com");
        user1.add("lol@mail.ru");
        Set<String> user2 = new HashSet<>();
        user2.add("foo@gmail.com");
        user2.add("ups@pisem.net");
        Set<String> user3 = new HashSet<>();
        user3.add("xyz@pisem.net");
        user3.add("vasya@pupkin.com");
        Set<String> user4 = new HashSet<>();
        user4.add("ups@pisem.net");
        user4.add("aaa@bbb.ru");
        Set<String> user5 = new HashSet<>();
        user5.add("xyz@pisem.net");
        input.put("User1", user1);
        input.put("User2", user2);
        input.put("User3", user3);
        input.put("User4", user4);
        input.put("User5", user5);
        Map<String, Set<String>> result = Email.merge(input);
        assertThat(result.size(), is(2));
        assertThat(result.get("User2").size(), is(5));
        assertThat(result.get("User5").size(), is(2));
        assertEquals(result.get("User2"), Set.of("xxx@ya.ru", "foo@gmail.com",
                "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
        assertEquals(result.get("User5"), Set.of("xyz@pisem.net", "vasya@pupkin.com"));
    }

    @Test
    public void whenNotMerge() {
        Map<String, Set<String>> input = new HashMap<>();
        input.put("User1", Set.of("xxx@ya.ru"));
        input.put("User2", Set.of("lol@mail.ru"));
        Map<String, Set<String>> result = Email.merge(input);
        assertThat(result.size(), is(2));
        assertEquals(result.get("User1"), Set.of("xxx@ya.ru"));
        assertEquals(result.get("User2"), Set.of("lol@mail.ru"));
    }

    @Test
    public void whenMergeToOneUser() {
        Map<String, Set<String>> input = new HashMap<>();
        Set<String> user1 = new HashSet<>();
        user1.add("xxx@ya.ru");
        user1.add("lol@mail.ru");
        Set<String> user2 = new HashSet<>();
        user2.add("lol@mail.ru");
        user2.add("ups@pisem.net");
        Set<String> user3 = new HashSet<>();
        user3.add("ups@pisem.net");
        user3.add("aaa@bbb.ru");
        input.put("User1", user1);
        input.put("User2", user2);
        input.put("User3", user3);
        Map<String, Set<String>> result = Email.merge(input);
        assertThat(result.size(), is(1));
        assertEquals(result.get("User2"), Set.of("xxx@ya.ru",
                "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
    }
}