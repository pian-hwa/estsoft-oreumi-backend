package day08;

import java.util.TreeSet;
import java.util.Comparator;

public class School {
    private String name;

    private TreeSet<Student> students =
            new TreeSet<>(Comparator.comparing(Student::getId));

    public School(String name) { this.name = name; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public TreeSet<Student> getStudents() { return students; }

    public void print() {
        System.out.println("School name: " + name);
        System.out.println("Students count: " + students.size());
    }

    public void printStudents() {
        for (Student student : students) {
            student.print();
        }
    }
}