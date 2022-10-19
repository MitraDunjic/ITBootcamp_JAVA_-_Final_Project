package SeleniumFinalProject.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Basic {
    public WebDriver webDriver;
    public WebDriverWait wait;
    public Action action;
    public Book book;
    public HomePage homePage;
    public KnjigeKojeVoleInspirisati knjigeKojeVoleInspirisati;
    public KontaktForma kontaktForma;
    public ListOfBooks listOfBooks;
    public Login login;
    public Pametnica pametnica;
    public Registracija registracija;
    public VolimCitati volimCitati;

    public Basic(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
        wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
    }

     public void clickOnElement(WebElement element) {
         Actions actions = new Actions(webDriver);
         actions.moveToElement(element).click().perform();
     }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void visabilityWait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
   }

}
