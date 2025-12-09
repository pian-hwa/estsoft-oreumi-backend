package day08;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private final Map<String, Integer> info = new HashMap<>();
    private String name;

    public Student(int year, int grade, int classnum, int number, String name) {
        setInfo(year, grade, classnum, number);
        setName(name);
    }

    public Student() {
        this(0, 0, 0, 0, null);
    }

    public void setInfo(int year, int grade, int classnum, int number) {
        try {
            if (year < 0 || grade < 0 || grade > 6 || classnum < 0 || number < 0)
                throw new InvalidIDException();

            this.info.put("Year", year);
            this.info.put("Grade", grade);
            this.info.put("Class", classnum);
            this.info.put("Number", number);
        } catch (InvalidIDException e) {
            System.err.println("ERROR: " + e.getMessage());
            resetInfo();
        } catch (Exception e) {
            System.err.println("ERROR: Something went wrong [\n"
                    + (e.getMessage() == null ? e.toString() : e.getMessage())
                    + "\n]");
            resetInfo();
        } finally {
            setId();
        }
    }

    private void setId() {
        this.id = String.format("%04d%01d%01d%02d",
                info.get("Year"),
                info.get("Grade"),
                info.get("Class"),
                info.get("Number"));
    }

    public void setName(String name) { this.name = name; }

    public Map<String, Integer> getInfo() { return this.info; }

    public String getId() {
        return String.format("%04d%01d%01d%02d",
                info.get("Year"),
                info.get("Grade"),
                info.get("Class"),
                info.get("Number"));
    }

    public String getName() { return this.name; }

    public void print() {
        System.out.printf("ID: %s, Name: %s\n", getId(), getName());
    }

    private void resetInfo() {
        this.info.put("Year", 0);
        this.info.put("Grade", 0);
        this.info.put("Class", 0);
        this.info.put("Number", 0);
    }
}