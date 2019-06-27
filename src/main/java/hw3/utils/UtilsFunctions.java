package hw3.utils;


import org.openqa.selenium.WebElement;
import hw3.user.User;

import java.util.List;
import java.util.stream.Collectors;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilsFunctions{

    public List<String> getTextFromListOfWebElements(List<WebElement> webElements) {
        return webElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public static User readUserFromFile(String filePath) {
        Properties prop = new Properties();
        User user = new User();
        try (FileInputStream input = new FileInputStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find user.properties");
            }
            prop.load(input);
            user.setLogin(prop.getProperty("login"));
            user.setPassword(prop.getProperty("password"));
            user.setName(prop.getProperty("name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
