import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[contains(@class, 'logo-display')]")
    private WebElement logoImg;

    @FindBy(css = "#navbar-menu > ul > li")
    private List<WebElement> navbarList;

    @FindBy(xpath = "//a[text() = 'KARİYER']")
    private WebElement careerLink;

    @FindBy(xpath = "//a[text() = 'Açık Pozisyonlar']")
    private WebElement servicesLink;

    @FindBy(xpath = "//a[text() = 'İstatistik']")
    private WebElement statisticsLink;

    @FindBy(xpath = "//a[text() = 'Yerleşkelerimiz']")
    private WebElement campusesLink;

    @FindBy(xpath = "//a[text() = 'Sunduğumuz Faydalar']")
    private WebElement benefitsLink;

    @FindBy(xpath = "//a[text() = 'Sosyal Alanlar']")
    private WebElement socialLink;

    @FindBy(xpath = "//a[contains(text(), 'GİRİŞ')]")
    private WebElement loginButton;


    public void navigateToHome() {
        driver.get("https://kariyer.baykartech.com/");
    }

    public boolean checkLogoVisibility() {
        return waitElementToBeVisible(driver, this.logoImg).isDisplayed();
    }

    public void hoverToCareerLink() {
        hoverToElement(this.careerLink);
    }

    public void clickStatisticsLink() {
        waitElementToBeClickable(driver, this.statisticsLink).click();
    }

    public void clickCampusesLink() {
        waitElementToBeClickable(driver, this.campusesLink).click();
    }

    public void clickBenefitsLink() { waitElementToBeClickable(driver, this.benefitsLink).click(); }

    public void clickSocialLink() { waitElementToBeClickable(driver, this.socialLink).click(); }

    public void clickServicesLink() { waitElementToBeClickable(driver, this.servicesLink).click(); }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public boolean checkDashboardButExists() {
        return driver.findElements(By.xpath("//a[contains(text(), 'DASHBOARD')]")).size() < 1;
    }
}
