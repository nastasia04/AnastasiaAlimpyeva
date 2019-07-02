package hw4.enums;

public enum PageTitles {
    HOMEPAGE("Home Page"),
    TABLEWITHPAGES("Table with pages"),
    METALSANDCOLORS("Metal and Colors");


    private final String name;

    PageTitles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

