package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(String.valueOf(target))))) {
            for (var src : sources) {
                zip.putNextEntry(new ZipEntry(src.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(src.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Template violation. Usage java -jar dir.jar -d=directory -e=exclude -o=output");
        }
        ArgsName argsMap = ArgsName.of(args);
        List<Path> files = Search.search((Paths.get(argsMap.get("d"))),
                file -> !file.toFile().getName().endsWith(argsMap.get("e")));
        new Zip().packFiles(files, Paths.get(argsMap.get("o")));
    }
}
