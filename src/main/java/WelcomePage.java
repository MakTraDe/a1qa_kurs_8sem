import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.03.2016.
 */
public class WelcomePage extends Page {
    public WelcomePage(AndroidDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        waitElementToBeClickableById("com.trello:id/log_in_button", 10);
        WebElement loginButton = getElementById("com.trello:id/log_in_button");
        if (loginButton != null) {
            executeClick(loginButton);
        }
        return new LoginPage(driver);
    }
}
