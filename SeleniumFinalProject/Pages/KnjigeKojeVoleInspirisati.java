package SeleniumFinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class KnjigeKojeVoleInspirisati extends Basic {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='input-sort']")
    private WebElement sortInput;

    public KnjigeKojeVoleInspirisati(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public ArrayList<String> getSveCene() {
        ArrayList<String> listaSvihCena = new ArrayList<String>();
        List<WebElement> cena = webDriver.findElements(By.xpath("//div[@class='caption']//div[@class='price']//span"));
        for (int i = 0; i < cena.size(); i++) {
            listaSvihCena.add(cena.get(i).getText());
        }
        return listaSvihCena;
    }
    public ArrayList<String> getSviNaslovi() {
        ArrayList<String> listaSvihNaslova = new ArrayList<String>();
        List<WebElement> naslov = webDriver.findElements(By.xpath("//div[@class='caption']//div[@class='name']//a"));
        for (int i = 0; i < naslov.size(); i++) {
            listaSvihNaslova.add(naslov.get(i).getText());
        }
        return listaSvihNaslova;
    }
    public void clickBookSortByValue(WebDriver driver, String value) {
        visabilityWait(sortInput);
        driver.findElement(By.xpath("//*[@id='input-sort']/option[text()='"+value+"']")).click();
    }
    public void clickSortInput(){
        sortInput.click();
    }


}

