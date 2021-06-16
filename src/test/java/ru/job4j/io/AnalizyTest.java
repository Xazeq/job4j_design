package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenFirstUnavailable() {
        String source = "./data/first_unavailable_server.log";
        String target = "./data/target.csv";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            StringBuilder result = new StringBuilder();
            in.lines()
                    .forEach(result::append);
            String expected = "10:13:02;10:14:55;"
                    + "10:15:12;10:15:22;";
            assertEquals(result.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenMiddleUnavailable() {
        String source = "./data/middle_unavailable_server.log";
        String target = "./data/target.csv";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            StringBuilder result = new StringBuilder();
            in.lines()
                    .forEach(result::append);
            String expected = "10:57:01;10:59:01;"
                    + "11:01:02;11:02:02;";
            assertEquals(result.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenLastUnavailable() {
        String source = "./data/last_unavailable_server.log";
        String target = "./data/target.csv";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            StringBuilder result = new StringBuilder();
            in.lines()
                    .forEach(result::append);
            String expected = "10:14:58;10:15:01;";
            assertEquals(result.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}