package ru.job4j.exam.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchFile extends SimpleFileVisitor<Path> {
    private final List<Path> files = new ArrayList<>();
    private final Map<String, String> arguments;

    public SearchFile(Map<String, String> arguments) {
        this.arguments = arguments;
    }

    public List<Path> getFiles() {
        return files;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (arguments.get("t").equals("mask")) {
            if (file.toString().endsWith(arguments.get("n").substring(1))) {
                files.add(file);
            }
        }
        if (arguments.get("t").equals("name")) {
            if (file.getFileName().toString().equals(arguments.get("n"))) {
                files.add(file);
            }
        }
        if (arguments.get("t").equals("regex")) {
            if (file.getFileName().toString().matches(arguments.get("n"))) {
                files.add(file);
            }
        }
        return super.visitFile(file, attrs);
    }
}
