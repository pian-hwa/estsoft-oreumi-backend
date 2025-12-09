package day08;

public class practice01 {
    public static void main(String[] args) {
        School school = new School("Example School");

        Student james = new Student(2025, 5, 1, 8, "James");
        Student michael = new Student(2025, 5, 1, 14, "Michael");
        Student hans = new Student(2025, 5, 1, 3, "Hans");

        school.addStudent(james);
        school.addStudent(michael);
        school.addStudent(hans);

        school.printStudents();
    }
}