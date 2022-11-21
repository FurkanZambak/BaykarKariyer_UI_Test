import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementToBeClickable(WebDriver driver, WebElement element, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeClickable(WebDriver driver, WebElement element) {
        return waitElementToBeClickable(driver, element, 5);
    }

    public WebElement waitElementToBeVisible(WebDriver driver, WebElement element, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeVisible(WebDriver driver, WebElement element) {
        return waitElementToBeVisible(driver, element, 5);
    }

    public void switchToNewTab(WebDriver driver, int tab) {
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(tab));
    }

    public void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void Click(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean checkPageUrl(String url) {
        return driver.getCurrentUrl().equals(url);
    }

    public void hoverToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
