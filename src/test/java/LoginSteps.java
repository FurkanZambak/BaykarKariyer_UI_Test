import com.thoughtworks.gauge.Step;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    @Step("Header alanının görünür olduğunun kontrol edilmesi")
    public void checkLoginHeaderIsVisible() {
        assertTrue(loginPage.checkLoginHeaderIsVisible());
    }

    @Step("Email alanına <email> değeri girilir")
    public void fillEmailInput(String email) {
        loginPage.fillEmailInput(email);
    }

    @Step("Şifre alanına <password> değeri girilir")
    public void fillPasswordInput(String password) {
        loginPage.fillPasswordInput(password);
    }

    @Step("Captcha checkboxının işaretlenmesi")
    public void checkCaptcha() throws InterruptedException  {
        loginPage.clickCaptchaField();
    }

    @Step("Giriş butonuna tıklanması")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("<alertCount> tane alan için <message> uyarısının tetiklendiğinin görülmesi")
    public void shouldValidationAlerts(String alertCount, String message) {
        assertTrue(loginPage.checkInvalidAlerts(message, Integer.parseInt(alertCount)));
    }
}
