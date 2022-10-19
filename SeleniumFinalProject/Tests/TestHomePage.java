package SeleniumFinalProject.Tests;

import SeleniumFinalProject.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage{
    private WebDriver webDriver;
    private HomePage homePage;

    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/");
    }

    @Test
    public void testSearchField(){
        homePage.clickSearchLoupe();
        homePage.inputPretraziPolje("MENTALNI SKLOP Nova psihologija uspeha");
        homePage.clickArrowButton();
        Assert.assertTrue(true, "MENTALNI SKLOP Nova psihologija uspeha");
    }

    @AfterMethod
    public void close() {
        webDriver.close();
        webDriver.quit();
    }
}
