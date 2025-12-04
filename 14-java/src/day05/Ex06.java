package day05;

public class Ex06 {
    public static void main(String[] args) {
        Person Jackson =  new Person();
        Person Carey =  new Person();
        Person Dean =  new Person();

        Jackson.setName("Michael Jackson");
        Jackson.setAge(24);

        Carey.setName("Mariah Carey");
        Carey.setAge(21);

        Dean.setName("James Dean");
        Dean.setAge(36);

        Jackson.print();
        Carey.print();
        Dean.print();
    }
}
