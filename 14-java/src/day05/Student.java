package day05;

public class Student {
    private String name;
    private int korean;
    private int math;
    private int english;
    private double average;
    private char grade;

    public Student(String name, int korean, int math, int english) {
        setName(name);
        setKorean(korean);
        setMath(math);
        setEnglish(english);
    }

    public Student() { this(null, 0, 0, 0); }

    public void setName(String name) { this.name = name; }
    public void setKorean(int score) { if (score >= 0 && score <= 100) korean = score; }
    public void setMath(int score) { if (score >= 0 && score <= 100) math = score; }
    public void setEnglish(int score) { if (score >= 0 && score <= 100) english = score; }

    public String getName() { return name; }
    public int getKorean() { return korean; }
    public int getMath() { return math; }
    public int getEnglish() { return english; }

    public double getAverage() {
        average = (korean + math + english) / 3.0;
        return average;
    }

    public char getGrade() {
        grade = 'F';

        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';

        return grade;
    }

    public void print() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.printf("Average: %.1f\n", getAverage());
        System.out.println("Grade: " + getGrade());
    }
}