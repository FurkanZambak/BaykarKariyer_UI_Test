import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import static org.junit.jupiter.api.Assertions.*;

public class PositionDetailSteps extends BaseTest {

    PositionDetailPage positionDetailPage = new PositionDetailPage(driver);

    @Step("Pozisyon bilgisinin sayfanın başında görüntülendiğinin kontrolü")
    public void shouldPageTitleBeValid() {
        String position = (String) ScenarioDataStore.get("positionInfo");
        assertTrue(positionDetailPage.checkPageHeaderIsValid(position));
    }

    @Step("Pozisyon bilgisinin detay kısmında görüntülendiğinin kontrolü")
    public void shouldPositionHeaderBeValid() {
        String position = (String) ScenarioDataStore.get("positionInfo");
        assertTrue(positionDetailPage.checkPositionHeaderIsValid(position));
    }

    @Step("Genel Nitelikler başlığının sayfada görüntülenmesi")
    public void shouldQualificationsTxtBeVisible() {
        assertTrue(positionDetailPage.checkQualificationsTxtIsVisible());
    }

    @Step("İş Tanımı başlığının sayfada görüntülenmesi")
    public void shouldJobDescTxtBeVisible() {
        assertTrue(positionDetailPage.checkJobDescTxtIsVisible());
    }

    @Step("Başvur butonunun sayfada görüntülenmesi")
    public void shouldApplyButBeVisible() {
        assertTrue(positionDetailPage.checkApplyButIsVisible());
    }
}
