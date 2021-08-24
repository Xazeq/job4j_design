package ru.job4j.gc;

public class User {
    private String login;
    private int password;
    private String email;

    public User(String login, int password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %s %d %s%n", login, password, email);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
