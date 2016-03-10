import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by New on 10.03.2016.
 */
public class MainSettingsBarPage extends Page {
    public MainSettingsBarPage(AndroidDriver driver) {
        super(driver);
    }

    public MainSettingsPage openMainSettingsPage() {
        List<WebElement> elements = getElementsById("com.trello:id/title");
        for(int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Settings")) {
                executeClick(elements.get(i));
                return new MainSettingsPage(driver);
            }
        }
        return null;
    }
}
