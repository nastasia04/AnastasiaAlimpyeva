package hw6.enums;

public enum ElementsCount {
    IMAGES(4),
    CHECKBOX(4),
    RADIO(4),
    SELECT(1),
    BUTTON(2),
    DROPDOWNS_ON_USER_TABLE_PAGE(6),
    NAMES_ON_USER_TABLE_PAGE(6),
    DESCRIPTION_IMAGES_ON_USER_TABLE_PAGE(6),
    DESCRIPTION_TEXTS_ON_USER_TABLE_PAGE(6),
    CHECKBOXES_ON_USER_TABLE_PAGE(6);

    private final int count;

    ElementsCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
