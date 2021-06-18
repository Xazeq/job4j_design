package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        String userMessage;
        String botAnswer;
        Scanner in = new Scanner(System.in);
        boolean isBotStopped = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(answers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            while (in.hasNextLine()) {
                userMessage = in.nextLine();
                writer.println("user: " + userMessage);
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
                    writer.println("bot: " + botAnswer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getBotAnswer(List<String> answers) {
        return answers.get((int) (Math.random() * answers.size()));
    }

    public static void main(String[] args) {
        new ConsoleChat("dialog.txt", "botAnswers.txt").run();
    }
}
