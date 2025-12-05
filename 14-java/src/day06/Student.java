package day06;

public class Student extends Person {
    private int id;
    private int year;
    private double gpa;
    public final boolean isValid;

    public Student(String name, int age, Gender gender, int id, int year, double gpa) {
        super(name, age, gender);

        if (setId(id) && setYear(year) && setGpa(gpa)) {
            isValid = true;
        } else {
            System.out.println("ERROR: Cannot set student.");
            isValid = false;
        }
    }

    private boolean setId(int id) {
        if (id < 0) {
            System.out.println("ERROR: Invalid id.");
            return false;
        }

        this.id = id;
        return true;
    }

    public boolean setYear(int year) {
        if (year < 0 || year > 7) {
            System.out.println("ERROR: Invalid year.");
            return false;
        }
        this.year = year;
        return true;
    }

    public boolean setGpa(double gpa) {
        if (gpa < 0 || gpa > 4.5) {
            System.out.println("ERROR: Invalid GPA.");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public int getId() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find student.");
            return 0;
        }
        return id;
    }

    public int getYear() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find student.");
            return 0;
        }
        return year;
    }

    public double getGPA() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find student.");
            return 0;
        }
        return gpa;
    }

    @Override
    public void print() {
        if (isValid) {
            super.print();
            System.out.println("ID: " + id);
            System.out.println("Year: " + year);
            System.out.println("GPA: " + gpa);
            System.out.println();
        } else System.out.println("ERROR: Cannot find student.");
    }
}