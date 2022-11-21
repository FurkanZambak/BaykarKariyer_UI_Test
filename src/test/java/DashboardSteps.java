import com.thoughtworks.gauge.Step;
import static org.junit.jupiter.api.Assertions.*;

public class DashboardSteps extends BaseTest {

    DashboardPage dashboardPage = new DashboardPage(driver);

    @Step("Profil ikonunda <abbr> kısaltmasının gözükmesi")
    public void shouldProfileIconBeVisible(String abbr) {
        assertTrue(dashboardPage.getProfileIcon(abbr).isDisplayed());
    }

    @Step("<abbr> ikonuna tıklayarak profil menüsünün açılması")
    public void openProfileMenu(String abbr) {
        dashboardPage.openProfileMenu(abbr);
    }

    @Step("Menüde <txt> textinin gözükmesi")
    public void shouldProfileIconOnMenuBeVisible(String txt) {
        assertTrue(dashboardPage.checkNameOnProfileMenu(txt));
    }

    @Step("Menüde <email> değerinin gözükmesi")
    public void shouldEmailOnMenuBeVisible(String email) {
        assertTrue(dashboardPage.checkEmailOnProfileMenu(email));
    }

    @Step("Profil header elementinin görünür olduğunun kontrolü")
    public void shouldProfileHeaderBeVisible() {
        assertTrue(dashboardPage.checkProfileHeaderIsVisible());
    }

    @Step("Profil alanında isim soyisim değeri <name> valid olduğunun kontrolü")
    public void shouldNameValueBeValid(String name) {
        assertTrue(dashboardPage.getNameElm().getText().equals(name));
        assertTrue(dashboardPage.getNameElm().isDisplayed());
    }

    @Step("Profil alanında telefon numarası değeri <phoneNo> valid olduğunun kontrolü")
    public void shouldPhoneNoValueBeValid(String phoneNo) {
        assertTrue(dashboardPage.getPhoneNoHeader().getText().equals(phoneNo));
        assertTrue(dashboardPage.getPhoneNoHeader().isDisplayed());
    }

    @Step("Profil alanında eposta değeri <email> valid olduğunun kontrolü")
    public void shouldEmailValueBeValid(String email) {
        assertTrue(dashboardPage.getEmailHeader().getText().equals(email));
        assertTrue(dashboardPage.getEmailHeader().isDisplayed());
    }

    @Step("<tabName> tabının aktif olduğunun kontrolü")
    public void shouldTabBeActive(String tabName) {
        assertTrue(dashboardPage.checkTabIsActive(tabName));
    }

    @Step("<tabName> durumunda kayıt varsa tabloda görüntülendiğinin kontrolü")
    public void shouldRegistersBeInTable(String tabName) {
        assertTrue(dashboardPage.checkRowStatus(tabName));
    }

    @Step("Tablo headerının değerinin <tabName> olduğunun kontrolü")
    public void shouldCheckTableHeader(String tabName) {
        assertTrue(dashboardPage.checkTableName(tabName));
    }

    @Step("<tabName> tabının aktif edilmesi")
    public void chooseATab(String tabName) {
        dashboardPage.selectTab(tabName);
    }

    @Step("Çıkış linkine tıklanır")
    public void clickLoguOutLink() {
        dashboardPage.clickLogOutLink();
    }

    @Step("Çıkış işlemi öncesinde modal ekranının açılması")
    public void shouldLogOutTxtBeVisible() {
        assertTrue(dashboardPage.checkLogOutTxtIsVisible());
    }

    @Step("Çıkış yap butonuna tıklanılır")
    public void clickLogOutBut() {
        dashboardPage.clickLogOutBut();
    }

}
