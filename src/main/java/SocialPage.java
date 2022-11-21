import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SocialPage extends BasePage {
    public SocialPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'SOSYAL ALANLAR']")
    private WebElement socialHeader;

    @FindBy(css = "#life_in_baykar .owl-next")
    private WebElement nextArrow;

    @FindBy(css = "#life_in_baykar .owl-prev")
    private WebElement prevArrow;

    public boolean checkSocialHeaderIsVisible() {
        return waitElementToBeVisible(driver,this.socialHeader).isDisplayed();
    }

    public String getSrcFromImg() {
        List<WebElement> activeFields = driver.findElements(By.cssSelector("#life_in_baykar .owl-item.active"));
        return activeFields.get(0).findElement(By.tagName("img")).getAttribute("src");
    }

    public boolean checkSlider(boolean isNext) throws InterruptedException {
        String src1 = getSrcFromImg();
        if(isNext) {
            Click(driver, waitElementToBeClickable(driver, this.nextArrow));
        }
        else {
            Click(driver, this.prevArrow);
        }
        Thread.sleep(2000);
        String src2 = getSrcFromImg();
        return src1.equals(src2);
    }
}
