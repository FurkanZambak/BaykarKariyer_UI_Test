import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text() = 'BAYKAR Kariyer Platformu Giriş']")
    private WebElement loginHeader;

    @FindBy(name = "login")
    private WebElement emailInput;

    @FindBy(id = "id_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//iframe[@title = 'reCAPTCHA']")
    private WebElement reCaptchaField;

    @FindBy(xpath = "//button[contains(text(), 'GİRİŞ')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private List<WebElement> alertList;

    public boolean checkLoginHeaderIsVisible() {
        return waitElementToBeVisible(driver, this.loginHeader).isDisplayed();
    }

    public void fillEmailInput(String email) {
        this.emailInput.sendKeys(email);
    }

    public void fillPasswordInput(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickCaptchaField() throws InterruptedException {
        this.reCaptchaField.click();
        Thread.sleep(2000);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public boolean checkInvalidAlerts(String message, int alertCount) {
        boolean flag = true;
        for (WebElement alertElm : this.alertList) {
            WebElement spanElm = alertElm.findElement(By.xpath(".//*[text() = '" + message + "']"));
            if(!spanElm.isDisplayed()) {
                flag = false;
                break;
            }
        }
        return flag && (alertCount == this.alertList.size());
    }
}
