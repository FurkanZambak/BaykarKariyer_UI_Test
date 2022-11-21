import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'kt_header_user_menu_toggle']")
    private WebElement profileMenu;

    @FindBy(xpath = "//*[contains(@class, 'menu-sub')]")
    private WebElement subMenu;

    @FindBy(xpath = "//a[text() = 'Çıkış']")
    private WebElement logOutLink;

    @FindBy(xpath = "//div[text() = 'Çıkış yapmak üzeresiniz.']")
    private WebElement logOutTxt;

    @FindBy(xpath = "//button[text() = 'Evet, çıkış yap.']")
    private WebElement logOutBut;

    @FindBy(xpath = "//button[text() = 'Hayır, geri dön.']")
    private WebElement cancelBut;

    @FindBy(xpath = "//h4[text() = 'Profil']")
    private WebElement profileHeader;

    @FindBy(xpath = "//*[text() = 'İsim Soyisim']/following-sibling::h3")
    private WebElement nameHeader;

    @FindBy(xpath = "//*[text() = 'Telefon']/following-sibling::h3")
    private WebElement phoneNoHeader;

    @FindBy(xpath = "//*[text() = 'E-Posta']/following-sibling::h3")
    private WebElement emailHeader;

    @FindBy(css = "#contentBody > tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//div[@id = 'notFound']//div[text() = 'İlgili Durumda Başvurunuz Bulunamadı']")
    private List<WebElement> notFoundTxt;

    @FindBy(id = "tableHeader")
    private WebElement tableHeader;

    public WebElement getProfileIcon(String abbr) {
        WebElement element = this.profileMenu.findElement(By.xpath("./div/span[contains(text(), '" + abbr + "')]"));
        return element;
    }

    public void openProfileMenu(String abbr) {
        getProfileIcon(abbr).click();
    }

    public boolean checkNameOnProfileMenu(String name) {
        WebElement element = this.subMenu.findElement(By.xpath(".//*[contains(text(), '" + name + "')]"));
        return waitElementToBeVisible(driver, element).isDisplayed();
    }

    public boolean checkEmailOnProfileMenu(String email) {
        WebElement element = this.subMenu.findElement(By.xpath(".//*[text() = '" + email + "']"));
        return element.isDisplayed();
    }

    public boolean checkProfileHeaderIsVisible() {
        return this.profileHeader.isDisplayed();
    }

    public WebElement getNameElm() {
        return this.nameHeader;
    }

    public WebElement getPhoneNoHeader() {
        return this.phoneNoHeader;
    }

    public WebElement getEmailHeader() {
        return this.emailHeader;
    }

    public boolean checkTableName(String tableName) {
        return this.tableHeader.getText().equals(tableName) && this.tableHeader.isDisplayed();
    }

    public int findRegisters(String tabName) {
        WebElement tab = driver.findElement(By.xpath("//*[@id = 'tabBar']//span[contains(text(), '" + tabName + "')]"));
        WebElement amount = tab.findElement(By.xpath(".//following-sibling::span"));
        return Integer.parseInt(amount.getText().replaceAll("[^0-9]+", ""));
    }

    public boolean checkTabIsActive(String tabName) {
        WebElement tab = driver.findElement(By.xpath("//*[@id = 'tabBar']//span[contains(text(), '" + tabName + "')]"));
        WebElement tabLink = tab.findElement(By.xpath("./.."));
        return tabLink.getAttribute("class").contains("active");
    }

    public void selectTab(String tabName) {
        WebElement tab = driver.findElement(By.xpath("//*[@id = 'tabBar']//span[contains(text(), '" + tabName + "')]"));
        tab.findElement(By.xpath("./..")).click();
    }

    public boolean checkRowStatus(String tabName) {
        boolean flag;
        int registerAmount = findRegisters(tabName);
        if(registerAmount > 0) {
            flag = (this.notFoundTxt.size() < 1) && (this.tableRows.size() == registerAmount);
        }
        else {
            flag = (this.notFoundTxt.size() == 1) && (this.tableRows.size() == registerAmount);
        }
        return flag;
    }

    public void clickLogOutLink() {
        this.logOutLink.click();
    }

    public void clickLogOutBut() {
        this.logOutBut.click();
    }

    public boolean checkLogOutTxtIsVisible() {
        return waitElementToBeVisible(driver, this.logOutTxt).isDisplayed();
    }

}
