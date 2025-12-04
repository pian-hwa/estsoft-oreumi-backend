package day05;

public class Person {
    private String name;
    private int age;

    public void setName(String str) { name = str; }
    public void setAge(int n) {
        if (n > 0) age = n;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void print() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}