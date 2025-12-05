package day06;

public class Teacher extends Person {
    private int id;
    private String subject;
    public final boolean isValid;

    public Teacher(String name, int age, Gender gender, int id, String subject) {
        super(name, age, gender);

        if (setId(id)) {
            isValid = true;
        } else {
            System.out.println("ERROR: Cannot set teacher.");
            isValid = false;
        }

        setSubject(subject);
    }

    private boolean setId(int id) {
        if (id < 0) {
            System.out.println("ERROR: Invalid id.");
            return false;
        }

        this.id = id;
        return true;
    }

    public void setSubject(String subject) { this.subject = subject; }

    public int getId() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find teacher.");
            return 0;
        }
        return id;
    }

    public String getSubject() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find teacher.");
            return null;
        }
        return subject;
    }

    @Override
    public void print() {
        if (isValid) {
            super.print();
            System.out.println("ID: " + id);
            System.out.println("Subject: " + subject);
            System.out.println();
        } else System.out.println("ERROR: Cannot find teacher.");
    }
}