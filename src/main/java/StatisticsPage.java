import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsPage extends BasePage {
    public StatisticsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'İSTATİSTİKLER']")
    private WebElement statisticsHeader;

    @FindBy(xpath = "//span[text() = 'Mühendis']")
    private WebElement engineerText;

    @FindBy(xpath = "//span[text() = 'Teknisyen']")
    private WebElement technicianText;

    @FindBy(xpath = "//span[text() = 'Çalışan']")
    private WebElement staffText;

    public boolean checkStatisticsHeaderIsVisible() {
        return waitElementToBeVisible(driver,this.statisticsHeader).isDisplayed();
    }

    public boolean checkEngineerTxtIsVisible() {
        return waitElementToBeVisible(driver, this.engineerText).isDisplayed();
    }

    public boolean checkEngineerCounter() throws InterruptedException {
        Thread.sleep(6000);
        WebElement counterElm = this.engineerText.findElement(By.xpath("./preceding-sibling::div[1]"));
        return counterElm.getAttribute("data-to").equals(counterElm.getText());
    }

    public boolean checkTechnicianTxtIsVisible() {
        return waitElementToBeVisible(driver, this.technicianText).isDisplayed();
    }

    public boolean checkTechnicianCounter() {
        WebElement counterElm = this.engineerText.findElement(By.xpath("./preceding-sibling::div[1]"));
        return counterElm.getAttribute("data-to").equals(counterElm.getText());
    }

    public boolean checkStaffTxtIsVisible() {
        return waitElementToBeVisible(driver, this.staffText).isDisplayed();
    }

    public boolean checkStaffCounter() {
        WebElement counterElm = this.staffText.findElement(By.xpath("./preceding-sibling::div[1]"));
        return counterElm.getAttribute("data-to").equals(counterElm.getText());
    }
}
