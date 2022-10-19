package SeleniumFinalProject.Tests;

import SeleniumFinalProject.Pages.Pametnica;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPametnica {
    private WebDriver webDriver;
    private Pametnica pametnica;

    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        pametnica = new Pametnica(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/");
    }
    @Test
    public void testUrlLoadedSuccessfully(){
        pametnica.clickPametnica();
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://pametnica.harfa.hr/" );
    }

    @AfterMethod
    public void close() {
        webDriver.close();
        webDriver.quit();
    }
}
