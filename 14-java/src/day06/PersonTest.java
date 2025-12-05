package day06;

public class PersonTest {
    public static void main(String[] args) {
        Teacher harry = new Teacher("Harry Potter", 37, Gender.MALE, 371, "Defence of the Dark");
        Student rose = new Student("Rose Granger-Weasley", 11, Gender.FEMALE, 7128, 2, 4.2);

        harry.print();
        rose.print();
    }
}