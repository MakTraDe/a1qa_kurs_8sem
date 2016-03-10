import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by New on 09.03.2016.
 */
public class BoardsPage extends Page {
    public BoardsPage(AndroidDriver driver) {
        super(driver);
    }

    public BoardPage openBoardByName(String name) {
        List<WebElement> boards = getElementsById("com.trello:id/board_name");
        for(int i = 0; i < boards.size(); i++) {
            if (boards.get(i).getText().equals(name)) {
                executeClick(boards.get(i));
                waitElementToBeClickableById("com.trello:id/action_bar", 5);
                return new BoardPage(driver);
            }
        }
        return null;
    }

    public int getBoardsCount() {
        return getElementsById("com.trello:id/board_name").size();
    }

    public AddBoardPage openAddBoardPage() {
        WebElement element = getElementById("com.trello:id/create_board");
        executeClick(element);
        return new AddBoardPage(driver);
    }

    public BoardSearchPage openBoardSearch() {
        waitElementToBeClickableById("com.trello:id/full_search", 5);
        WebElement element = getElementById("com.trello:id/full_search");
        executeClick(element);
        return new BoardSearchPage(driver);
    }

    public MainSettingsBarPage openMainSettingsBar() {
        WebElement element = getElementsByClassName("android.widget.ImageView").get(1);
        executeClick(element);
        return new MainSettingsBarPage(driver);
    }
}
