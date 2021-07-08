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
        SearchFile searchFile = new SearchFile(search.arguments);
        Files.walkFileTree(Path.of(search.arguments.get("d")), searchFile);
        search.files = searchFile.getFiles();

        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                    new FileOutputStream(search.arguments.get("o"))))) {
            search.files.forEach(printWriter::println);
        }
    }
}
