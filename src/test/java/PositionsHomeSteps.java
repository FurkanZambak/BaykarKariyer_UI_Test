import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;

import static org.junit.jupiter.api.Assertions.*;

public class PositionsHomeSteps extends BaseTest {

    PositionsHomePage positionsHomePage = new PositionsHomePage(driver);

    @Step("Açık Pozisyonlar header alanının görünür olduğunun kontrolü")
    public void shouldServicesHeaderBeVisible() {
        assertTrue(positionsHomePage.checkServicesHeaderIsVisible());
    }

    @Step("Açık Pozisyon sliderının ileri yönde çalıştığının kontrolü")
    public void shouldSlideForward() throws InterruptedException {
        assertFalse(positionsHomePage.checkSlider(true));
    }

    @Step("Açık Pozisyon sliderının geri yönde çalıştığının kontrolü")
    public void shouldSlideBackward() throws InterruptedException {
        assertFalse(positionsHomePage.checkSlider(false));
    }

    @Step("Sliderda Detay butonlarının bulunduğunun kontrolü")
    public void shouldHaveADetailButton() {
        assertTrue(positionsHomePage.checkDetailButtons());
    }

    @Step("Seçili pozisyon için detay sayfasının açılması")
    public void openDetailPage() {
        String positionInfo = positionsHomePage.openDetailPage();
        ScenarioDataStore.put("positionInfo", positionInfo);
    }
}
