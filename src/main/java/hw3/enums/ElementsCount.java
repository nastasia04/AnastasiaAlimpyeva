package hw3.enums;

public enum ElementsCount {
    IMAGES(4),
    CHECKBOX(4),
    RADIO(4),
    SELECT(1),
    BUTTON(2);
    private final int count;

    ElementsCount(int count ) { this.count = count;}

    public int getCount() {
        return count;
    }
}
