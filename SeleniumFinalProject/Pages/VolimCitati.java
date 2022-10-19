package SeleniumFinalProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VolimCitati extends ListOfBooks {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='cart']/button")
    private WebElement korpa;

    @FindBy(xpath = "//*[@id='cart']/ul/li/p")
    private WebElement korpaMenu;

    @FindBy(xpath = "//*[@id='cart']/ul/li/p/a")
    private WebElement pregledKorpe;


    String backURL = "https://www.knjizara-harfa.rs/volim-citati/";

    public VolimCitati(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(super.webDriver, this);
    }

    public void clickKorpa(){
        clickOnElement(this.korpa);
    }
    public String GetTextKorpa(){
        return korpaMenu.getText();
    }
}
