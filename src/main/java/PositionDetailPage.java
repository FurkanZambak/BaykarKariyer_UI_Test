import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PositionDetailPage extends BasePage {
    public PositionDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text() = 'GENEL NİTELİKLER']")
    private WebElement qualifications;

    @FindBy(xpath = "//*[text() = 'İŞ TANIMI']")
    private WebElement jobDesc;

    @FindBy(css = ".btnBaykar")
    private WebElement applyBut;

    public boolean checkPageHeaderIsValid(String position) {
        return driver.findElement(By.xpath("//h1[text() = '" + position + "']")).isDisplayed();
    }

    public boolean checkPositionHeaderIsValid(String position) {
        return driver.findElement(By.xpath("//h4[text() = '" + position + "']")).isDisplayed();
    }

    public boolean checkApplyButIsVisible() {
        return this.applyBut.isDisplayed();
    }

    public boolean checkQualificationsTxtIsVisible() {
        return this.qualifications.isDisplayed();
    }

    public boolean checkJobDescTxtIsVisible() {
        return this.jobDesc.isDisplayed();
    }
}
