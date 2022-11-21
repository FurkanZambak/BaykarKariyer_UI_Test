import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampusesPage extends BasePage {

    public CampusesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'YERLEŞKELERİMİZ']")
    private WebElement campusesHeader;

    public boolean checkCampusesHeaderIsVisible() {
        return waitElementToBeVisible(driver,this.campusesHeader).isDisplayed();
    }

    public void selectCampus(String campusVal) {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + campusVal + "')]"));
        Click(driver, waitElementToBeClickable(driver, element));
    }

    public boolean checkCampusIsActive(String txt) {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + txt + "')]"));
        WebElement parentElm = element.findElement(By.xpath("./.."));
        return parentElm.getAttribute("class").equals("active");
    }

    public boolean checkCampusTitleVisible(String title) {
        WebElement element = waitElementToBeVisible(driver, driver.findElement(By.xpath("//h2[text() = '" + title + "']")));
        return element.isDisplayed();
    }

    public boolean checkCampusTxtVisible(String txt) {
        WebElement element = driver.findElement(By.xpath("//p[contains(text(), '" + txt + "')]"));
        return element.isDisplayed();
    }
}
