package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class CinemaTest {

    @Test
    @Ignore
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 9, 1, 20, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    @Ignore
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    @Ignore
    public void add() {
        Cinema cinema = new Cinema3D();
        Session newSession = new Session3D();
        cinema.add(newSession);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.get(0), is(newSession));
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void whenIncorrectDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1990, 1, 1, 10, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void whenPlaceIsOccupied() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 9, 1, 10, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket ticket2 = cinema.buy(account, 1, 1, date);
    }
}