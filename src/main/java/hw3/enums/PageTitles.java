package hw3.enums;

public enum PageTitles {
    HOMEPAGE("Home Page"),
    DIFFERENTELEMNTS("Different Elements");

    private final String name;

    PageTitles(String name) { this.name = name;}

    @Override
    public String toString() {
        return name;
    }
}

