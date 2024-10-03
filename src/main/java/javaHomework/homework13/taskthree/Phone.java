package javaHomework.homework13.taskthree;

public class Phone {
    private boolean isPortable;

    public Phone(boolean isPortable) {
        this.isPortable = isPortable;
    }

    public boolean getIsPortable() {
        return isPortable;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "isPortable=" + isPortable +
                '}';
    }
}
