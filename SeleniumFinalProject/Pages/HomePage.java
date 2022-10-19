package SeleniumFinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Basic {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='top-links']//span[text()='Prijava']")
    private WebElement prijavaHomePage;

    @FindBy(xpath = "//*[@id='top-links']//span[text()='Registracija']")
    private WebElement registracijaHomePage;

    @FindBy(xpath= "//div[@id='tm_menu']//*[text()='Kontakt']")
    private WebElement kontaktHomePage;

    @FindBy(xpath ="//*[@id='tm_menu']//*[text()='Knjižara']")
    private WebElement knjizaraHomePage;

    @FindBy(xpath ="//*[@id='tm_menu']//*[text()='Knjige koje vole decu']")
    private WebElement knjigeKojeVoleDecu;

    @FindBy(xpath="//*[@id='tm_menu']//*[text()='Volim čitati']")
    private WebElement volimCitati;

    @FindBy(xpath ="//*[@id='tm_menu']//*[text()='Knjige koje vole inspirisati']" )
    private WebElement knjigeKojeVoleInspirisati;
    @FindBy(xpath ="//*[@id='gorelogo']//*[@class='fa fa-search']" )
    private WebElement searchLoupe;
    @FindBy(xpath ="//*[@id='search']//*[@placeholder='Pretraži']" )
    private WebElement pretraziPolje;

    @FindBy(xpath ="//*[@id='search']//*[@class='button-search']" )
    private WebElement arrowButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickPrijavaNavBar() {
        this.prijavaHomePage.click();
    }
    public void clickRegistracijaNavBar() {
        this.registracijaHomePage.click();
    }

    public void clickKontaktHomePage() {
        this.kontaktHomePage.click();
    }

    public void clickVolimCitati() {
        visabilityWait(this.volimCitati);
        this.volimCitati.click();
    }

    public void clicknjigeKojeVoleInspirisati() {
        visabilityWait(this.knjigeKojeVoleInspirisati);
        this.knjigeKojeVoleInspirisati.click();
    }
    public void clickToKnjizara() {
        visabilityWait(this.knjizaraHomePage);
        clickOnElement(this.knjizaraHomePage);
    }

    public void clickToKnjigeKojeVoleDecu() {
        visabilityWait(this.knjigeKojeVoleDecu);
        clickOnElement(this.knjigeKojeVoleDecu);
    }
    public void hoverToKnjigeKojeVoleInspirisati() {
        visabilityWait(this.knjigeKojeVoleInspirisati);
    }
    public void clickSearchLoupe() {
        this.searchLoupe.click();
    }
    public void inputPretraziPolje(String name) {
        visabilityWait(this.pretraziPolje);
        clickOnElement(this.pretraziPolje);
        pretraziPolje.clear();
        pretraziPolje.sendKeys(name);
    }
    public void clickArrowButton() {
        this.arrowButton.click();
    }
}

