package javaHomework.homework11.taskthree;

public enum Therapy {
    TESTS("Get blood & urine tested"),
    XRAY("Take an x-ray"),
    SURGEON("Undergo surgery"),
    DRESSING("Change bandages");

private String description;

    Therapy(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
