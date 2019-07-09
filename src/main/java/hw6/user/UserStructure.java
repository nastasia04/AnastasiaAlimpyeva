package hw6.user;

import lombok.Getter;
import lombok.Setter;

// TODO You could add @Getter & @Setter here. - fixed
// TODO @ToString could be added also here
@Getter @Setter
public class UserStructure {
    private String number;
    private String user;
    private String description;

    public String toString() {

        return number.concat(user).concat(description).replaceAll("\n", " ");
    }


}