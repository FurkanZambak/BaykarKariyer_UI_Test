import com.thoughtworks.gauge.Step;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BenefitsSteps extends BaseTest {

    BenefitsPage benefitsPage = new BenefitsPage(driver);

    @Step("Sunduğumuz Faydalar header elementinin görünürlüğü kontrol edilir")
    public void shouldCampusesHeaderBeVisible() {
        assertTrue(benefitsPage.checkBenefitsHeaderIsVisible());
    }

    /*@Step("<campus> imkanının default seçili olduğunun kontrolü")
    public void shouldCheckDefaultCampus(String campus) {
        assertTrue(campusesPage.checkCampusIsActive(campus));
    }*/

    @Step("<benefit> title değerinin kontrol edilmesi")
    public void shouldCheckBenefitTitle(String benefit) {
        assertTrue(benefitsPage.checkBenefitTitleVisible(benefit));
    }

    @Step("Seçili imkan değerinin açıklamasının <txt> textini içermesi")
    public void shouldCheckBenefitText(String txt) {
        assertTrue(benefitsPage.checkBenefitTxtVisible(txt));
    }

    @Step("<benefit> imkanının seçilmesi")
    public void selectBenefit(String benefit) {
        benefitsPage.selectBenefit(benefit);
    }
}
