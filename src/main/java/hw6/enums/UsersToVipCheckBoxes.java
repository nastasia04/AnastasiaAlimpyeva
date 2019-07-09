package hw6.enums;

public enum UsersToVipCheckBoxes {
    ROMAN("roman"),
    SERGEY_IVAN("ivan"),
    VLADZIMIR("vlad"),
    HELEN_BENNETT("helen"),
    YOSHI_TANNAMURI("yoshi"),
    GIOVANNI_ROVELLI("gio");

    final String idVipCheckBox;

    UsersToVipCheckBoxes(String idVipCheckBox) {
        this.idVipCheckBox = idVipCheckBox;
    }

    public String getIdVipCheckBox() {
        return idVipCheckBox;
    }
}

