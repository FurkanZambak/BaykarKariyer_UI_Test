import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BenefitsPage extends BasePage {
    public BenefitsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'SUNDUĞUMUZ FAYDALAR']")
    private WebElement benefitsHeader;

    public boolean checkBenefitsHeaderIsVisible() {
        return waitElementToBeVisible(driver,this.benefitsHeader).isDisplayed();
    }

    public void selectBenefit(String benefitVal) {
        WebElement element = driver.findElement(By.xpath("//div[contains(@class, 'tab-navigation')]//h4[text() = '" + benefitVal + "']"));
        Click(driver, waitElementToBeClickable(driver, element));
    }

    public boolean checkCampusIsActive(String txt) {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + txt + "')]"));
        WebElement parentElm = element.findElement(By.xpath("./.."));
        return parentElm.getAttribute("class").equals("active");
    }

    public boolean checkBenefitTitleVisible(String title) {
        WebElement element = waitElementToBeVisible(driver, driver.findElement(By.xpath("(//h4[text() = '" + title + "'])[2]")));
        return element.isDisplayed();
    }

    public boolean checkBenefitTxtVisible(String txt) {
        WebElement element = driver.findElement(By.xpath("//div[@id = 'benefits']//p[contains(text(), '" + txt + "')]"));
        return element.isDisplayed();
    }
}
