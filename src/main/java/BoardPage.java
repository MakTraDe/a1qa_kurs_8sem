import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.03.2016.
 */
public class BoardPage extends Page {
    public BoardPage(AndroidDriver driver) {
        super(driver);
    }

    public BoardSettingBarPage openSettings() {
        waitElementToBeClickableById("com.trello:id/board_sections", 10);
        WebElement button = getElementById("com.trello:id/board_sections");
        executeClick(button);
        return new BoardSettingBarPage(driver);
    }

    public String getCurrentTitle() {
        WebElement element = getElementByClassName("android.widget.TextView");
        return element.getText();
    }

    public CardViewPage openCard() {
        WebElement element = getElementById("com.trello:id/cardText");
        executeClick(element);
        return new CardViewPage(driver);
    }

    public BoardsPage backToBoards() {
        WebElement backButton = getElementByClassName("android.widget.ImageButton");
        executeClick(backButton);
        return new BoardsPage(driver);
    }
}
