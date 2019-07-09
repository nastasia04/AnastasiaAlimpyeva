package hw6.enums;

public enum DropDown {
    YELLOW("Yellow"),
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green");
    private final String option;

    DropDown(String option) {
        this.option = option;}

    @Override
    public String toString() {
        return option;
    }
}
