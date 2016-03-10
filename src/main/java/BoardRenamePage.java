import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.03.2016.
 */
public class BoardRenamePage extends Page {
    public BoardRenamePage(AndroidDriver driver) {
        super(driver);
    }

    public void enterNewTitle(String title) {
        WebElement input = getElementById("android:id/edit");
        insertText(input, title);
    }

    public BoardSettingsSubBarPage save() {
        WebElement button = getElementById("android:id/button1");
        executeClick(button);
        return new BoardSettingsSubBarPage(driver);
    }
}
