package hw6.user;

import lombok.Getter;
import lombok.Setter;

public class UserStructure {

    @Getter
    @Setter
    private String number;
    @Getter
    @Setter
    private String user;
    @Getter
    @Setter
    private String description;

    public String toString() {

        return number.concat(user).concat(description).replaceAll("\n", " ");
    }


}