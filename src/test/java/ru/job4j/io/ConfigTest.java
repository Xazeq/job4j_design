package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Ivan"));
        assertThat(config.value("surname"), is("Ivanov"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenWrongTemplate() {
        String path = "./data/wrong_template.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
        public void whenWithCommentAndEmptyLine() {
        String path = "./data/comment_empty_line.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr"));
        assertThat(config.value("surname"), is("Petrov"));
    }
}