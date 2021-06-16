package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
        PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            StringBuilder result = new StringBuilder();
            in.lines()
                    .forEach(line -> {
                        String[] str = line.split(" ");
                        if (str[0].equals("400") || str[0].equals("500")) {
                            if (result.length() == 0) {
                                result.append(str[1]).append(";");
                            }
                        }
                        if (str[0].equals("200") || str[0].equals("300")) {
                            if (result.length() != 0) {
                                result.append(str[1]).append(";");
                                out.println(result);
                                result.setLength(0);
                            }
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
