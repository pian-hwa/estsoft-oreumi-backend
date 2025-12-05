package day06;

public class Person {
    private String name;
    private int age;
    private Gender gender;
    public final boolean isValid;

    public Person(String name, int age, Gender gender) {
        setName(name);

        if (setAge(age)) {
            isValid = true;
        } else {
            System.out.println("ERROR: Cannot set person");
            isValid = false;
        }

        setGender(gender);
    }

    public void setName(String name) { this.name = name; }

    public boolean setAge(int age) {
        if (age < 0) {
            System.out.println("ERROR: Invalid age.");
            return false;
        }

        this.age = age;
        return true;
    }

    public void setGender(Gender gender) {  this.gender = gender; }

    public String getName() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find person.");
            return null;
        }
        return name;
    }

    public int getAge() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find person.");
            return 0;
        }
        return age;
    }

    public Gender getGender() {
        if (!isValid) {
            System.out.println("ERROR: Cannot find person.");
            return null;
        }
        return gender;
    }

    public void print() {
        if (isValid) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Gender: " + gender);
        } else System.out.println("ERROR: Cannot find person.");
    }
}
