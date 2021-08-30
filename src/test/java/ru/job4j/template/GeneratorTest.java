package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class GeneratorTest {

    @Ignore
    @Test
    public void correctProduce() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan Ivanov");
        map.put("subject", "you");
        Generator generator = new SomeGenerator();
        String result = generator.produce("I am a ${name}, Who are ${subject}?", map);
        String expected = "I am a Ivan Ivanov, Who are you?";
        assertThat(result, is(expected));
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenNotEnoughKeys() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan Ivanov");
        Generator generator = new SomeGenerator();
        String result = generator.produce("I am a ${name}, Who are ${subject}?", map);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenMoreKeys() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan Ivanov");
        map.put("subject", "you");
        map.put("key", "value");
        Generator generator = new SomeGenerator();
        String result = generator.produce("I am a ${name}, Who are ${subject}?", map);
    }
}