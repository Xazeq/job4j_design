package ru.job4j.exam.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    private final Map<String, String> arguments = new HashMap<>();
    private List<Path> files;


    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Должно быть 4 агрумента: "
                    + "-d - директория, в которой начинать поиск, "
                    + "-n - имя файла, маска, либо регулярное выражение, "
                    + "-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению, "
                    + "-o - результат записать в файл");
        }
        Search search = new Search();
        for (var arg : args) {
            String[] argument = arg.split("=");
            if (argument.length != 2) {
                throw new IllegalArgumentException("Неверно заполнен шаблон ключ=значение");
            }
            search.arguments.put(argument[0].substring(1), argument[1]);
        }
        search.findFiles(search);
        search.writeFiles(search);
    }

    private void findFiles(Search search) throws IOException {
        SearchFile searchFile = new SearchFile(search.getPredicate());
        Files.walkFileTree(Path.of(search.arguments.get("d")), searchFile);
        search.files = searchFile.getFiles();
    }

    private void writeFiles(Search search) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(search.arguments.get("o"))))) {
            search.files.forEach(printWriter::println);
        }
    }

    private Predicate<Path> getPredicate() {
        return switch (arguments.get("t")) {
            case "mask" -> (file -> file.toString().endsWith(arguments.get("n").substring(1)));
            case "name" -> (file -> file.getFileName().toString().equals(arguments.get("n")));
            case "regex" -> (file -> {
                Pattern pattern = Pattern.compile(arguments.get("n"));
                Matcher matcher = pattern.matcher(file.getFileName().toString());
                return matcher.find();
            });
            default -> throw new IllegalArgumentException("Неверный тип поиска");
        };
    }
}
