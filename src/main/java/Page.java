import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by New on 09.03.2016.
 */
public abstract class Page {
    protected AndroidDriver driver;

    public Page(AndroidDriver driver) {
        this.driver = driver;
    }

    protected WebElement getElementById(String id) {
        try {
            return driver.findElement(By.id(id));
        } catch (Exception ex) {
            return null;
        }
    }

    protected boolean executeClick(WebElement element) {
        try {
            element.click();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected void waitElementToBeClickable(WebElement element, int duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElementToBeClickableById(String id, int duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    protected void waitElementToBeClickableByXpath(String xPath, int duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    protected WebElement getElementByXpath(String xPath) {
        try {
            return driver.findElement(By.xpath(xPath));
        } catch (Exception ex) {
            return null;
        }
    }

    protected String getCurrentActivity() {
        return driver.currentActivity();
    }

    protected void insertText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected WebElement getElementByClassName(String className) {
        try {
            return driver.findElement(By.className(className));
        } catch (Exception ex) {
            return null;
        }
    }

    protected List<WebElement> getElementsByClassName(String className) {
        try {
            return driver.findElements(By.className(className));
        } catch (Exception ex) {
            return new ArrayList<WebElement>();
        }
    }

    protected List<WebElement> getElementsById(String id) {
        try {
            return driver.findElements(By.id(id));
        } catch (Exception ex) {
            return new ArrayList<WebElement>();
        }
    }
}
