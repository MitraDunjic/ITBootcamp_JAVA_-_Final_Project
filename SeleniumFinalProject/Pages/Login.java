package SeleniumFinalProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Basic{

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement email;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement lozinka;

    @FindBy(xpath = "//*[@class='link-login']")
    private WebElement zaboravljenaLozinka;
    @FindBy(xpath = "//*[@id='formalogin']/input")
    private WebElement prijavaButton;

    @FindBy(xpath = "//*[@class='form-control']")
    private WebElement emailZaboravljenaLozinka;

    @FindBy(xpath = "//*[@value='Nova lozinka']")
    private WebElement novaLozinkaButton;

    @FindBy(xpath = "//*[@class='alert alert-warning']")
    private WebElement zabranjenPristup;


    public Login(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void inputEmailField(String email) {
        this.email.sendKeys(email);
    }
    public void inputLozinkaField(String lozinka) {
        this.lozinka.sendKeys(lozinka);
    }
    public String getTextLoginExistingUserIncorrectEmailOrPassword() {
        visabilityWait(this.zabranjenPristup);
        return zabranjenPristup.getText();
    }
    public void clickPrijava() {
        scrollIntoView(this.prijavaButton);
        this.prijavaButton.click();
    }


}
