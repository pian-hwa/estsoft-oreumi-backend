package day06;

public class DeskLamp {
    private boolean isOn;

    public DeskLamp(boolean isOn) { this.isOn = isOn; }
    public DeskLamp() { this(false); }

    public DeskLamp turnOn() {
        this.isOn = true;
        return this;
    }
    public DeskLamp turnOff() {
        this.isOn = false;
        return this;
    }

    public void printStatus() {
        System.out.println("Status:" + (isOn ? "On" : "Off"));
    }
}