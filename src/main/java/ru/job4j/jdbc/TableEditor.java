package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        execute(String.format("create table %s();",
                tableName));
    }

    public void dropTable(String tableName) {
        execute(String.format("drop table %s;",
                tableName));
    }

    public void addColumn(String tableName, String columnName, String type) {
        execute(String.format("alter table %s add column %s %s;",
                tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) {
        execute(String.format("alter table %s drop column %s;",
                tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        execute(String.format("alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName));
    }

    private void execute(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
