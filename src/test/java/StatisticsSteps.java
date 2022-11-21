import com.thoughtworks.gauge.Step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatisticsSteps extends BaseTest {

    StatisticsPage statisticsPage = new StatisticsPage(driver);

    @Step("İstatistikler header elementinin görünürlüğü kontrol edilir")
    public void shouldStatisticsHeaderBeVisible() {
        assertTrue(statisticsPage.checkStatisticsHeaderIsVisible());
    }

    @Step("Mühendis text alanının görünürlüğünün kontrol edilmesi")
    public void shouldEngineerTxtBeVisible() {
        assertTrue(statisticsPage.checkEngineerTxtIsVisible());
    }

    @Step("Mühendis sayacının değerinin doğru olduğunun kontrolü")
    public void shouldEngineerCounterBeValid() throws InterruptedException {
        assertTrue(statisticsPage.checkEngineerCounter());
    }

    @Step("Teknisyen text alanının görünürlüğünün kontrol edilmesi")
    public void shouldTechnicianTxtBeVisible() {
        assertTrue(statisticsPage.checkTechnicianTxtIsVisible());
    }

    @Step("Teknisyen sayacının değerinin doğru olduğunun kontrolü")
    public void shouldTechnicianCounterBeValid() {
        assertTrue(statisticsPage.checkTechnicianCounter());
    }

    @Step("Çalışan text alanının görünürlüğünün kontrol edilmesi")
    public void shouldStaffTxtBeVisible() {
        assertTrue(statisticsPage.checkStaffTxtIsVisible());
    }

    @Step("Çalışan sayacının değerinin doğru olduğunun kontrolü")
    public void shouldStaffCounterBeValid() {
        assertTrue(statisticsPage.checkStaffCounter());
    }
}
