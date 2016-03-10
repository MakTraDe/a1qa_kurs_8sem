import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by New on 09.03.2016.
 */
public class TrelloTest {
    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Nexus 7");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", "com.trello.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority = 0)
    public void testAuthorize() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.waitElementToBeClickableById("com.trello:id/log_in_button", 10);
        LoginPage loginPage = welcomePage.openLoginPage();
        loginPage.enterLogin("rr@ultralab.by");
        loginPage.enterPassword("********");
        BoardsPage boardsPage = loginPage.clickLogin();
        boardsPage.waitElementToBeClickableById("com.trello:id/primary_text", 5);
        org.testng.Assert.assertTrue(boardsPage.getElementsById("com.trello:id/primary_text") != null);
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 1)
    public void renameBoard() {
        BoardsPage boardsPage = new BoardsPage(driver);
        boardsPage.waitElementToBeClickableById("com.trello:id/primary_text", 10);
        BoardPage boardPage = boardsPage.openBoardByName("rty");
        BoardSettingBarPage boardSettingBarPage = boardPage.openSettings();
        BoardSettingsSubBarPage boardSettingsSubBarPage = boardSettingBarPage.openSubBar();
        BoardRenamePage boardRenamePage = boardSettingsSubBarPage.openRenamePage();
        boardRenamePage.enterNewTitle("Test1");
        boardSettingsSubBarPage = boardRenamePage.save();
        boardPage = boardSettingsSubBarPage.backToBoard();
        org.testng.Assert.assertEquals(boardPage.getCurrentTitle(), "rtyTest1");
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 2)
    public void disableComments() {
        BoardsPage boardsPage = new BoardsPage(driver);
        boardsPage.waitElementToBeClickableById("com.trello:id/primary_text", 10);
        BoardPage boardPage = boardsPage.openBoardByName("rty");
        BoardSettingBarPage boardSettingBarPage = boardPage.openSettings();
        BoardSettingsSubBarPage boardSettingsSubBarPage = boardSettingBarPage.openSubBar();
        BoardCommentingPage boardCommentingPage = boardSettingsSubBarPage.openCommentingPage();
        boardSettingsSubBarPage = boardCommentingPage.setCommentsDisabled();
        boardPage = boardSettingsSubBarPage.backToBoard();
        CardViewPage cardViewPage = boardPage.openCard();
        org.testng.Assert.assertEquals(cardViewPage.isCommentFieldExists(), false);
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 3)
    public void enableComments() {
        BoardsPage boardsPage = new BoardsPage(driver);
        boardsPage.waitElementToBeClickableById("com.trello:id/primary_text", 10);
        BoardPage boardPage = boardsPage.openBoardByName("rty");
        BoardSettingBarPage boardSettingBarPage = boardPage.openSettings();
        BoardSettingsSubBarPage boardSettingsSubBarPage = boardSettingBarPage.openSubBar();
        BoardCommentingPage boardCommentingPage = boardSettingsSubBarPage.openCommentingPage();
        boardSettingsSubBarPage = boardCommentingPage.setCommentsMembers();
        boardPage = boardSettingsSubBarPage.backToBoard();
        CardViewPage cardViewPage = boardPage.openCard();
        org.testng.Assert.assertEquals(cardViewPage.isCommentFieldExists(), true);
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 4)
    public void addBoard() {
        BoardsPage boardsPage = new BoardsPage(driver);
        boardsPage.waitElementToBeClickableById("com.trello:id/primary_text", 10);
        int boardsCountBeforeAdding = boardsPage.getBoardsCount();
        AddBoardPage addBoardPage = boardsPage.openAddBoardPage();
        addBoardPage.enterTitle("Test1");
        BoardPage boardPage = addBoardPage.save();
        boardsPage = boardPage.backToBoards();
        int boardsCountAfterAdding = boardsPage.getBoardsCount();
        org.testng.Assert.assertEquals(boardsCountAfterAdding, boardsCountBeforeAdding + 1);
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 5)
    public void boardSearch() {
        BoardsPage boardsPage = new BoardsPage(driver);
        BoardSearchPage boardSearchPage = boardsPage.openBoardSearch();
        boardSearchPage.enterTextForSearch("test");
        org.testng.Assert.assertTrue(boardSearchPage.processResults("test"));
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 6)
    public void logout() {
        BoardsPage boardsPage = new BoardsPage(driver);
        boardsPage.waitElementToBeClickableById("com.trello:id/primary_text", 10);
        MainSettingsBarPage mainSettingsBarPage = boardsPage.openMainSettingsBar();
        MainSettingsPage mainSettingsPage = mainSettingsBarPage.openMainSettingsPage();
        WelcomePage welcomePage = mainSettingsPage.logout();
        welcomePage.waitElementToBeClickableById("com.trello:id/log_in_button", 10);
        org.testng.Assert.assertTrue(welcomePage.getElementById("com.trello:id/log_in_button") != null);
    }
}
