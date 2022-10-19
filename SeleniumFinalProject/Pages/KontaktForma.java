package SeleniumFinalProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KontaktForma extends Basic{

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='Ime']")
    private WebElement ime;

    @FindBy(xpath = "//*[@id='Prezime']")
    private WebElement prezime;

    @FindBy(xpath = "//*[@id='Telefon']")
    private WebElement telefon;

    @FindBy(xpath = "//*[@id='Email']")
    private WebElement email;

    @FindBy(xpath = "//div[@class= 'col-sm-9']/img")
    private WebElement sigurnosniKod;

    @FindBy(xpath = "//*[@id='kod']")
    private WebElement prepisaniSigurnosniKod;

    @FindBy(xpath = "//*[@id='Napomena']")
    private WebElement poruka;

    @FindBy(xpath = "//div[@class='buttons']//*[@value='Pošalji']")
    private WebElement posaljiButton;

    @FindBy(xpath="//*[@class='alert-danger']")
    private WebElement alert;
    public KontaktForma(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void inputNameField(String ime) {
        this.ime.sendKeys(ime);
    }
    public void inputSurnameField(String prezime) {
        this.prezime.sendKeys(prezime);
    }
    public void inputPhoneField(String telefon) {
        this.telefon.sendKeys(telefon);
    }
    public void inputEmailField(String email) {
        this.email.sendKeys(email);
    }
    public void inputSecurityCodeField(String prepisaniSigurnosniKod) {
        this.prepisaniSigurnosniKod.sendKeys(prepisaniSigurnosniKod);
    }
    public void inputMessageField(String poruka) {
        this.poruka.sendKeys(poruka);
    }

    public void clickPosalji() {
        scrollIntoView(posaljiButton);
        this.posaljiButton.submit();
    }
    public String GetAlertText(){
        return this.alert.getText();
     }
}
