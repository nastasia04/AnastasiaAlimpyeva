package hw3.enums;

public enum CheckBox {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");
    private final String option;

    CheckBox(String option) { this.option = option;}

    @Override
    public String toString() {
        return option;
    }
}
