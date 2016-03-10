import io.appium.java_client.android.AndroidDriver;

/**
 * Created by New on 10.03.2016.
 */
public class CardViewPage extends Page {
    public CardViewPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isCommentFieldExists() {
        return getElementById("com.trello:id/add_comment_edit_text") != null;
    }
}
