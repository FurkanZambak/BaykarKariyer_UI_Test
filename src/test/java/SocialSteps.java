import com.thoughtworks.gauge.Step;

import static org.junit.jupiter.api.Assertions.*;

public class SocialSteps extends BaseTest {

    SocialPage socialPage = new SocialPage(driver);

    @Step("Sosyal alanlar header elementinin görünürlüğü kontrol edilir")
    public void shouldSocialHeaderBeVisible() {
        assertTrue(socialPage.checkSocialHeaderIsVisible());
    }

    @Step("Sliderın ileri yönde çalıştığının kontrolü")
    public void shouldSlideForward() throws InterruptedException {
        assertFalse(socialPage.checkSlider(true));
    }

    @Step("Sliderın geri yönde çalıştığının kontrolü")
    public void shouldSlideBackward() throws InterruptedException {
        assertFalse(socialPage.checkSlider(false));
    }
}
