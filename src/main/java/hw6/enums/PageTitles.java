package hw6.enums;

public enum PageTitles {
    HOME_PAGE("Home Page"),
    USER_TABLE("User Table"),
    DIFFERENT_ELEMENTS("Different Elements");

    private final String name;

    PageTitles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

