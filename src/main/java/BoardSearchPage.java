import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by New on 10.03.2016.
 */
public class BoardSearchPage extends Page {
    public BoardSearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterTextForSearch(String text) {
        waitElementToBeClickableById("com.trello:id/edit_text", 5);
        WebElement element = getElementById("com.trello:id/edit_text");
        insertText(element, text);
    }

    public boolean processResults(String text) {
        Pattern p = Pattern.compile("\\*" + text + "\\*");
        List<WebElement> elements = getElementsById("com.trello:id/board_name");
        for (int i = 0; i < elements.size(); i++) {
            Matcher m = p.matcher(elements.get(i).getText());
            boolean b = m.matches();
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
