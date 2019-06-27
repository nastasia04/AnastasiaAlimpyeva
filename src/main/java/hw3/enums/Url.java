package hw3.enums;

public enum Url {
    HOME("https://epam.github.io/JDI/"),
    GITHUB("https://github.com/epam/JDI");
    private final String url;

    Url(String url) { this.url = url;}

    @Override
    public String toString() {
        return url;
    }
}
