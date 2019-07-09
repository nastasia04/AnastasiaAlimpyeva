package hw6.enums;

public enum Radio {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");
    private final String option;

    Radio(String option) { this.option = option;}

    @Override
    public String toString() {
        return option;
    }
}
