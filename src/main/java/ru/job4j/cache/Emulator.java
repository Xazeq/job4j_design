package ru.job4j.cache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache cache = new DirFileCache("./files/");
        String cities = cache.get("cities.txt");
        System.out.println(cities);
        String names = cache.get("names.txt");
        System.out.println(names);

        /*AbstractCache<String, String> cache = new DirFileCache("./files/");
        String cities = cache.get("cities.txt");
        System.out.println(cities);
        String names = cache.get("names.txt");
        System.out.println(names);*/
    }
}