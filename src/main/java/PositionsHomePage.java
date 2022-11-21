import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PositionsHomePage extends BasePage {
    public PositionsHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong[text() = 'Açık Pozİsyonlar']")
    private WebElement servicesHeader;

    @FindBy(css = "#services .owl-next")
    private WebElement nextArrow;

    @FindBy(css = "#services .owl-prev")
    private WebElement prevArrow;

    @FindBy(css = "#services .owl-item.active")
    private List<WebElement> activeItems;

    public boolean checkServicesHeaderIsVisible() {
        return waitElementToBeVisible(driver, this.servicesHeader).isDisplayed();
    }

    public String getTextFromHeader() {
        return this.activeItems.get(0).findElement(By.tagName("h4")).getText();
    }

    public boolean checkSlider(boolean isNext) throws InterruptedException {
        String text1 = getTextFromHeader();
        if(isNext) {
            Click(driver, waitElementToBeClickable(driver, this.nextArrow));
        }
        else {
            Click(driver, this.prevArrow);
        }
        Thread.sleep(2000);
        String text2 = getTextFromHeader();
        return text1.equals(text2);
    }

    public boolean checkDetailButtons() {
        boolean flag = true;
        for (WebElement item : this.activeItems) {
            if((item.findElements(By.xpath(".//a[text() = 'Detay']"))).size() < 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public String openDetailPage() {
        WebElement firstItem = this.activeItems.get(0);
        String position = firstItem.findElement(By.tagName("h4")).getText();
        firstItem.findElement(By.xpath(".//a[text() = 'Detay']")).click();
        return position;
    }
}
