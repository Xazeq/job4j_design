package ru.job4j.gc;

import java.util.Arrays;

public class GarbDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        User[] users = new User[10000];
        int count = 0;
        int limit = 1000;
        while (true) {
            for (int i = count; i < limit; i++) {
                users[count] = new User("L" + i, i, "E" + i);
                if (count < users.length - 1) {
                    count++;
                }
            }
            for (int i = 0; i < 100; i++) {
                users[count - 1 - i] = null;
                count--;
            }
            if (count > 9000) {
                Arrays.fill(users, null);
                count = 0;
                limit = 1000;
            }
            limit += 1000;
        }
    }
}
