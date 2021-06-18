package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answers = new ArrayList<>();
        readBotAnswers(botAnswers, answers);
        List<String> log = new ArrayList<>();
        String userMessage;
        String botAnswer;
        Scanner in = new Scanner(System.in);
        boolean isBotStopped = false;
        while (in.hasNextLine()) {
            userMessage = in.nextLine();
            log.add("user: " + userMessage);
            if (userMessage.equals(OUT)) {
                break;
            }
            if (userMessage.equals(CONTINUE)) {
                isBotStopped = false;
            }
            if (userMessage.equals(STOP)) {
                isBotStopped = true;
            }
            if (!isBotStopped) {
                botAnswer = getBotAnswer(answers);
                System.out.println("bot: " + botAnswer);
                log.add("bot: " + botAnswer);
            }
        }
        writeLogToFile(log);
    }

    private void readBotAnswers(String botAnswersPath, List<String> answers) {
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswersPath))) {
            reader.lines().forEach(answers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeLogToFile(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (var line : log) {
                writer.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getBotAnswer(List<String> answers) {
        return answers.get((int) (Math.random() * answers.size()));
    }

    public static void main(String[] args) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH-mm-ss"));
        new ConsoleChat("log_" + date + ".txt", "botAnswers.txt").run();
    }
}
