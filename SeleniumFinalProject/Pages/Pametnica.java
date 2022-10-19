package SeleniumFinalProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pametnica extends Basic{
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='gorelogo']//*[contains(text(), 'Pametnica')]")
    private WebElement pametnica;

    public Pametnica(WebDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickPametnica() {
        visabilityWait(this.pametnica);
        this.pametnica.click();
    }
}
