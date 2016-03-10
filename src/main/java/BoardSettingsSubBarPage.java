import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by New on 09.03.2016.
 */
public class BoardSettingsSubBarPage extends Page {
    public BoardSettingsSubBarPage(AndroidDriver driver) {
        super(driver);
    }

    public BoardRenamePage openRenamePage() {
        WebElement button = getElementById("android:id/title");
        executeClick(button);
        return new BoardRenamePage(driver);
    }

    public BoardCommentingPage openCommentingPage() {
        List<WebElement> buttons = getElementsById("android:id/title");
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Commenting")) {
                executeClick(buttons.get(i));
                return new BoardCommentingPage(driver);
            }
        }
        return null;
    }

    public BoardPage backToBoard() {
        WebElement backButton = getElementByClassName("android.widget.ImageButton");
        executeClick(backButton);
        return new BoardPage(driver);
    }
}
