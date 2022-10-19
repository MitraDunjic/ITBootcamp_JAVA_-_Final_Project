package SeleniumFinalProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book extends Basic {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id='ima']/span")
    private WebElement bookUKorpu;

    @FindBy(xpath = "//ul[@class='breadcrumb']//li[3]")
    private WebElement bookBack;


    public Book(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickBookUKorpu() {
        visabilityWait(this.bookUKorpu);
        this.bookUKorpu.click();
    }
    public void clickBackBook() {
        visabilityWait(this.bookBack);
        clickOnElement(this.bookBack);
    }
}
