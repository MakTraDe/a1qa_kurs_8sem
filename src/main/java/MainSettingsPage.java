import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by New on 10.03.2016.
 */
public class MainSettingsPage extends Page {
    public MainSettingsPage(AndroidDriver driver) {
        super(driver);
    }

    public WelcomePage logout(){
        List<WebElement> elements = getElementsById("android:id/title");
        for(int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Log out")) {
                executeClick(elements.get(i));
                return new WelcomePage(driver);
            }
        }
        return null;
    }
}
