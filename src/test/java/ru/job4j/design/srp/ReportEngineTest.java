package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenITReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportIT(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head><title>IT Report</title></head>")
                .append("<body>")
                .append("<h1>Name; Hired; Fired; Salary;</h1>")
                .append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenITReportWith2WorkersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Egor", now, now, 100);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportIT(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head><title>IT Report</title></head>")
                .append("<body>")
                .append("<h1>Name; Hired; Fired; Salary;</h1>")
                .append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>")
                .append(System.lineSeparator())
                .append("<p>")
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append("</p>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountingReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 0.87).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Egor", now, now, 150);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONReportGenerated() {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.set(2021, 8, 30, 0, 0, 0);
        Employee worker = new Employee("Ivan", date, date, 100);
        Employee worker2 = new Employee("Egor", date, date, 150);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportJSON(store);
        String expect =
                "{"
                    + "\"name\":\"Ivan\","
                    + "\"hired\":"
                        + "{"
                            + "\"year\":2021,"
                            + "\"month\":8,"
                            + "\"dayOfMonth\":30,"
                            + "\"hourOfDay\":0,"
                            + "\"minute\":0,"
                            + "\"second\":0"
                        + "},"
                    + "\"fired\":"
                        + "{"
                            + "\"year\":2021,"
                            + "\"month\":8,"
                            + "\"dayOfMonth\":30,"
                            + "\"hourOfDay\":0,"
                            + "\"minute\":0,"
                            + "\"second\":0"
                        + "},"
                    + "\"salary\":100.0"
                + "}"
                + System.lineSeparator()
                + "{"
                    + "\"name\":\"Egor\","
                    + "\"hired\":"
                        + "{"
                            + "\"year\":2021,"
                            + "\"month\":8,"
                            + "\"dayOfMonth\":30,"
                            + "\"hourOfDay\":0,"
                            + "\"minute\":0,"
                            + "\"second\":0"
                        + "},"
                    + "\"fired\":"
                        + "{"
                            + "\"year\":2021,"
                            + "\"month\":8,"
                            + "\"dayOfMonth\":30,"
                            + "\"hourOfDay\":0,"
                            + "\"minute\":0,"
                            + "\"second\":0"
                        + "},"
                    + "\"salary\":150.0"
                + "}"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenXMLReportGenerated() {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.set(2021, 8, 30, 0, 0, 0);
        Employee worker = new Employee("Ivan", date, date, 100);
        Employee worker2 = new Employee("Egor", date, date, 150);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n")
                .append("<employee name=\"Ivan\" salary=\"100.0\"/>")
                .append("\n")
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n")
                .append("<employee name=\"Egor\" salary=\"150.0\"/>")
                .append("\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}