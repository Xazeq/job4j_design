package ru.job4j.collection.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> previousMap = new HashMap<>();
        int added = 0;
        int changed = 0;
        int deleted;
        for (var user : previous) {
            previousMap.put(user.id, user.name);
        }
        for (var user : current) {
            if (previousMap.get(user.id) == null) {
                added++;
                continue;
            }
            if (!previousMap.get(user.id).equals(user.name)) {
                changed++;
            }
        }
        deleted = previous.size() + added - current.size();
        return new Info(added, changed, deleted);
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
