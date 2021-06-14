package ru.job4j.io;

import java.io.FileOutputStream;

public class WriteMatrix {
    public static void main(String[] args) {
        int[][] matrix = Matrix.multiple(5);
        writeTable(matrix);
    }

    public static void writeTable(int[][] matrix) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] array : matrix) {
                for (int value : array) {
                    String str = value + " ";
                    out.write(str.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
