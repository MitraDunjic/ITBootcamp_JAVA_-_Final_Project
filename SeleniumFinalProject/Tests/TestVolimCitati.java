package SeleniumFinalProject.Tests;

import SeleniumFinalProject.Pages.Book;
import SeleniumFinalProject.Pages.HomePage;
import SeleniumFinalProject.Pages.VolimCitati;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestVolimCitati {
    private WebDriver webDriver;
    private HomePage homePage;
    private VolimCitati volimCitati;
    private Book book;

    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        volimCitati = new VolimCitati(webDriver);
        book = new Book(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/");
    }
    @Test
    public void addToCart() {

        homePage.clickToKnjizara();
        homePage.clickToKnjigeKojeVoleDecu();
        homePage.clickVolimCitati();
        volimCitati.clickDetaljnijeKnjiga(0);
        book.clickBookUKorpu();
        book.clickBackBook();
        volimCitati.clickDetaljnijeKnjiga(2);
        book.clickBookUKorpu();
        book.clickBackBook();
        volimCitati.clickDetaljnijeKnjiga(4);
        book.clickBookUKorpu();
        book.clickBackBook();
        volimCitati.clickKorpa();
        Assert.assertEquals(volimCitati.GetTextKorpa(), "U korpi imate 3 proizvoda,\n" +
                "ukupno (bez poštarine): 6.750,00 din\n" +
                "Pregled korpe");
    }
        @AfterMethod
    public void close() {
        webDriver.close();
        webDriver.quit();
    }
}
