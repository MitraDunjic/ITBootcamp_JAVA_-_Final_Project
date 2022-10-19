package SeleniumFinalProject.Tests;

import SeleniumFinalProject.Pages.KontaktForma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class TestKontaktForma {
    private WebDriver webDriver;
    private KontaktForma kontaktForma;

    private SeleniumFinalProject.Pages.HomePage homePage;

    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        kontaktForma = new KontaktForma(webDriver);
        homePage = new SeleniumFinalProject.Pages.HomePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/");
    }
    @Test
    public void clickSendWithIncorrectSecurityCode(){
        homePage.clickKontaktHomePage();
        kontaktForma.inputNameField(Faker.instance().bothify("?????"));
        kontaktForma.inputSurnameField(Faker.instance().bothify("????????"));
        kontaktForma.inputPhoneField(Faker.instance().phoneNumber().phoneNumber());
        kontaktForma.inputEmailField(Faker.instance().bothify("?????####@gmail.com"));
        kontaktForma.inputSecurityCodeField(Faker.instance().bothify("???"));
        kontaktForma.inputMessageField(Faker.instance().bothify("###????****"));
        kontaktForma.clickPosalji();
        String expected = "Poruka nije poslana!\nPogrešno upisan sigurnosni kod!";
        Assert.assertEquals(kontaktForma.GetAlertText(), expected);
    }

    @AfterMethod
    public void close() {
        webDriver.close();
        webDriver.quit();
    }

}
