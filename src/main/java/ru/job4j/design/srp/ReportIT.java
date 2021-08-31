package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportIT implements Report {
    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head><title>IT Report</title></head>")
                .append("<body>")
                .append("<h1>Name; Hired; Fired; Salary;</h1>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}