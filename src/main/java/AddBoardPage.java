import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 10.03.2016.
 */
public class AddBoardPage extends Page {
    public AddBoardPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterTitle(String title) {
        waitElementToBeClickableById("com.trello:id/organization", 10);
        WebElement input = getElementById("com.trello:id/board_name");
        insertText(input, title);
    }

    public BoardPage save() {
        WebElement button = getElementById("android:id/button1");
        executeClick(button);
        return new BoardPage(driver);
    }
}
