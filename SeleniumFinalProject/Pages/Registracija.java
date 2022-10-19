package SeleniumFinalProject.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registracija extends Basic{

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='content']//*[text()='OVDE']")
    private WebElement ovde;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='sprytextfield3']/span[text()='Neispravan unos']")
    private WebElement neispravanUnos;

    @FindBy(xpath = "//*[@id='loza1']")
    private WebElement odaberiteLozinku;

    @FindBy(xpath = "//*[@id='sprytextfield1']/span[text()='Najmanje 6 znakova']")
    private WebElement najmanjeSestZnakova;

    @FindBy(xpath = "//*[@id='loza2']")
    private WebElement ponoviteLozinku;

    @FindBy(xpath = "//*[@id='sprytextfield2']/span[text()='Potrebno upisati']")
    private WebElement potrebnoUpisati;

    @FindBy(xpath = "//*[@id='tvrtka']")
    private WebElement registriraSeFirmaCheckBox;

    @FindBy(xpath = "//*[@id='Ziro_racun']")
    private WebElement PIB;

    @FindBy(xpath = "//*[@id='Ime']")
    private WebElement imeIprezime;

    @FindBy(xpath = "//*[@id='adresa']")
    private WebElement ulicaIBroj;

    @FindBy(xpath = "//*[@id='grad']")
    private WebElement postanskiBrojGrad;

    @FindBy(xpath = "//*[@id='drzava']")
    private WebElement drzava;

    @FindBy(xpath = "//*[@id='tel_fax']")
    private WebElement brojMobilnog;

    @FindBy(xpath = "//*[@id='kod']")
    private WebElement sigurnosniKod;

    @FindBy(xpath = "//*[@id='slazemse']")
    private WebElement usloviCheckBox;

    @FindBy(xpath = "//*[@id='sprytextfield7']/a[text()='Opće uvete korišćenja']")
    private WebElement opstiUslovi;

    @FindBy(xpath = "//*[@id='sprytextfield7']/a[text()='Uslove prodaje']")
    private WebElement usloviProdaje;

    @FindBy(xpath = "//*[@id='button']")
    private WebElement registracijaButton;

    @FindBy(xpath = "//*[@id='container']/div/div/div/div")
    private WebElement dangerAlert;

    public Registracija(WebDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String getTextDangerAlert(){
        visabilityWait(this.dangerAlert);
        return dangerAlert.getText();
    }
    public String getTextNeispravanUnos(){
        return this.neispravanUnos.getText();
    }
    public String getTextNeispravanUnosLozinke(){
        return this.najmanjeSestZnakova.getText();
    }
    public String getTextPotrebnoUpisati(){
        return this.potrebnoUpisati.getText();
    }
    public void inputEmailField(String email) {
        this.email.sendKeys(email);
    }
    public void inputPasswordField(String odaberiteLozinku) {
        this.odaberiteLozinku.sendKeys(odaberiteLozinku);
    }
    public void inputPasswordAgainField(String ponoviteLozinku) {
        this.ponoviteLozinku.sendKeys(ponoviteLozinku);
    }
    public void inputPIBField(String PIB) {
        this.PIB.sendKeys(PIB);
    }
    public void inputNameSurnameField(String imeIprezime) {
        this.imeIprezime.sendKeys(imeIprezime);
    }
    public void inputAdressField(String ulicaIBroj) {
        scrollIntoView(this.ulicaIBroj);
        this.ulicaIBroj.sendKeys(ulicaIBroj);
    }
    public void inputCityField(String postanskiBrojGrad) {
        this.postanskiBrojGrad.sendKeys(postanskiBrojGrad);
    }
    public void inputPhoneField(String brojMobilnog) {
        visabilityWait(this.brojMobilnog);
        this.brojMobilnog.sendKeys(brojMobilnog);
    }
    public void inputSecurityCodeField(String sigurnosniKod) {
        scrollIntoView(this.sigurnosniKod);
        this.sigurnosniKod.sendKeys(sigurnosniKod);
    }
    public void clickRegistriraSeFirmaCheckBox() {
        clickOnElement(this.registriraSeFirmaCheckBox);
    }
    public void selectState(String state){
        clickOnElement(this.drzava);
        this.drzava.sendKeys(state);
        this.drzava.sendKeys(Keys.TAB);

}
    public void clickUsloviCheckBox() {
        scrollIntoView(this.usloviCheckBox);
        clickOnElement(this.usloviCheckBox);
    }
    public void clickOpstiUslovi(){
        this.opstiUslovi.click();
    }
    public void clickUsloviProdaje(){
        this.usloviProdaje.click();
    }
    public void clickOvde(){
        this.ovde.click();
    }
    public void clickEmailField(){
        this.email.sendKeys(Keys.ENTER);
    }
    public void clickPasswordField(){
        this.odaberiteLozinku.sendKeys(Keys.ENTER);
    }
    public void clickPasswordFieldAgain(){
        this.ponoviteLozinku.sendKeys(Keys.ENTER);

    }
    public void clickPIBField(){
        this.PIB.sendKeys(Keys.ENTER);
    }

    public void clickRegistracijaButton(){
        scrollIntoView(this.registracijaButton);
        this.registracijaButton.click();
    }
}
