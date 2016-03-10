import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.03.2016.
 */
public class LoginPage extends Page {
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        WebElement loginField = getElementById("com.trello:id/user");
        if (loginField != null) {
            insertText(loginField, login);
        }
    }

    public void enterPassword(String password) {
        WebElement passwordField = getElementById("com.trello:id/password");
        if (passwordField != null) {
            insertText(passwordField, password);
        }
    }

    public BoardsPage clickLogin() {
        WebElement loginButton = getElementById("com.trello:id/authenticate");
        executeClick(loginButton);
        return new BoardsPage(driver);
    }
}
