import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by New on 10.03.2016.
 */
public class BoardCommentingPage extends Page {
    public BoardCommentingPage(AndroidDriver driver) {
        super(driver);
    }

    public BoardSettingsSubBarPage setCommentsDisabled() {
        List<WebElement> buttons = getElementsById("android:id/text1");
        executeClick(buttons.get(0));
        return new BoardSettingsSubBarPage(driver);
    }

    public BoardSettingsSubBarPage setCommentsMembers() {
        List<WebElement> buttons = getElementsById("android:id/text1");
        executeClick(buttons.get(1));
        return new BoardSettingsSubBarPage(driver);
    }
}
