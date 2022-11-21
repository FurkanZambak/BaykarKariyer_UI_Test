import com.thoughtworks.gauge.Step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CampusesSteps extends BaseTest {
    CampusesPage campusesPage = new CampusesPage(driver);

    @Step("Yerleşkelerimiz header elementinin görünürlüğü kontrol edilir")
    public void shouldCampusesHeaderBeVisible() {
        assertTrue(campusesPage.checkCampusesHeaderIsVisible());
    }

    @Step("<campus> yerleşkesinin default seçili olduğunun kontrolü")
    public void shouldCheckDefaultCampus(String campus) {
        assertTrue(campusesPage.checkCampusIsActive(campus));
    }

    @Step("<campus> title değerinin doğruluğunun kontrol edilmesi")
    public void shouldCheckCampusTitle(String campus) {
        assertTrue(campusesPage.checkCampusIsActive(campus));
        assertTrue(campusesPage.checkCampusTitleVisible(campus));
    }

    @Step("Paragraf alanında <campus> değerinin gözükmesi")
    public void shouldCheckCampusText(String campus) {
        assertTrue(campusesPage.checkCampusTxtVisible(campus));
    }

    @Step("<campus> kampüsünün seçilmesi")
    public void selectCampus(String campus) {
        campusesPage.selectCampus(campus);
    }
}
