package hw6.enums;

public enum Header {
    MAINHEADER("EPAM framework Wishes…"),
    MAINHEADERTEXT("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
            "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
    GITHUB_HEADER("JDI Github");
    private final String text;

    Header(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
