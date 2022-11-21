import com.thoughtworks.gauge.Step;
import static org.junit.jupiter.api.Assertions.*;

public class HomePageSteps extends BaseTest {

    HomePage homePage = new HomePage(driver);

    @Step("Kariyer BaykarTech anasayfasının açılması")
    public void openHomePage() {
        homePage.navigateToHome();
    }

    @Step("Anasayfanın açıldığının kontrolü")
    public void shouldHomePageOpened() {
        assertTrue(homePage.checkPageUrl("https://kariyer.baykartech.com/tr/"));
    }

    @Step("Logonun anasayfada görünür olduğunun kontrolü")
    public void shouldLogoBeVisible() {
        assertTrue(homePage.checkLogoVisibility());
    }

    @Step("Sayfa url değerinin <url> olduğunun kontrol edilmesi")
    public void shouldCurrentUrlEqualUrl(String url) {
        assertTrue(homePage.checkPageUrl(url));
    }

    @Step("Kariyer linkine mouse hover yapılır")
    public void checkNavbarElements() {
        homePage.hoverToCareerLink();
    }

    @Step("Açık Pozisyonlar linkine tıklanır")
    public void clickServicesLink() { homePage.clickServicesLink(); }

    @Step("İstatistik linkine tıklanır")
    public void clickStatisticsLink() {
        homePage.clickStatisticsLink();
    }

    @Step("Yerleşkelerimiz linkine tıklanır")
    public void clickCampusesLink() {
        homePage.clickCampusesLink();
    }

    @Step("Sunduğumuz Faydalar linkine tıklanır")
    public void clickBenefitsLink() {
        homePage.clickBenefitsLink();
    }

    @Step("Sosyal Alanlar linkine tıklanır")
    public void clickSocialLink() { homePage.clickSocialLink(); }

    @Step("Login sayfası için Giriş butonuna tıklanır")
    public void clickLoginButton() {
        homePage.clickLoginButton();
    }

    @Step("Anasayfada Dashboard butonunun bulunmadığının kontrolü")
    public void shouldDashboardButNotExist() {
        assertTrue(homePage.checkDashboardButExists());
    }

}
