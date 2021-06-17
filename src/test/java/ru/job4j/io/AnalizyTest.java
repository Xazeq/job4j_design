package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenFirstUnavailable() throws IOException {
        File source = folder.newFile("first_unavailable_server.log");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("400 10:13:02");
            out.println("500 10:14:22");
            out.println("300 10:14:55");
            out.println("200 10:15:01");
            out.println("500 10:15:12");
            out.println("200 10:15:22");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(result::append);
        }
        String expected = "10:13:02;10:14:55;"
                + "10:15:12;10:15:22;";
        assertThat(result.toString(), is(expected));
    }

    @Test
    public void whenMiddleUnavailable() throws IOException {
        File source = folder.newFile("first_unavailable_server.log");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(result::append);
        }
        String expected = "10:57:01;10:59:01;"
                + "11:01:02;11:02:02;";
        assertThat(result.toString(), is(expected));
    }

    @Test
    public void whenLastUnavailable() throws IOException {
        File source = folder.newFile("first_unavailable_server.log");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("300 10:14:55");
            out.println("400 10:14:58");
            out.println("200 10:15:01");
            out.println("400 10:13:02");
            out.println("500 10:14:22");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(result::append);
        }
        String expected = "10:14:58;10:15:01;";
        assertThat(result.toString(), is(expected));
    }
}