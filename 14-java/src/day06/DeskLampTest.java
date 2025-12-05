package day06;

public class DeskLampTest {
    public static void main(String[] args) {
        DeskLamp myLamp = new DeskLamp();

        myLamp.turnOn().printStatus();
        myLamp.turnOff().printStatus();
    }
}