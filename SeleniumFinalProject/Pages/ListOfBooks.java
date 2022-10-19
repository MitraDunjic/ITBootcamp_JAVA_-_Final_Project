package SeleniumFinalProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ListOfBooks extends Basic{
    WebDriver webDriver;

    public ListOfBooks(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickDetaljnijeKnjiga(int bookNumber){
        List<WebElement> knjige = webDriver.findElements(By.xpath("//*[@id='content']//div[contains(@class, 'product-thumb')]//button"));
        int temp = bookNumber+1;
        knjige.get(temp).click();
    }
    public ArrayList<String> getNasloviUSreachListi() {
        ArrayList<String> listaSvihNaslova = new ArrayList<String>();
        List<WebElement> naslov = webDriver.findElements(By.xpath("//div[@class='caption']//div[@class='name']//a"));
        for (int i = 0; i < naslov.size(); i++) {
            listaSvihNaslova.add(naslov.get(i).getText());
        }
        return listaSvihNaslova;
    }



}
