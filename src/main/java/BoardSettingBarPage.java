import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.03.2016.
 */
public class BoardSettingBarPage extends Page {
    public BoardSettingBarPage(AndroidDriver driver) {
        super(driver);
    }

    public BoardSettingsSubBarPage openSubBar() {
        WebElement button = getElementById("com.trello:id/settings_button");
        executeClick(button);
        return new BoardSettingsSubBarPage(driver);
    }

    public BoardPage back() {
        WebElement element = getElementById("com.trello:id/listName");
        executeClick(element);
        return new BoardPage(driver);
    }
}
