package SeleniumFinalProject.Tests;

import SeleniumFinalProject.Pages.HomePage;
import SeleniumFinalProject.Pages.Registracija;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRegistracija {

    private WebDriver webDriver;
    private HomePage homePage;
    private Registracija registracija;

    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new SeleniumFinalProject.Pages.HomePage(webDriver);
        registracija = new Registracija(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/registracija.php");
    }
    @Test
    public void testClickOvde(){
       homePage.clickRegistracijaNavBar();
       webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       registracija.clickOvde();
       Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.knjizara-harfa.rs/login.php", "URL should be https://www.knjizara-harfa.rs/login.php");
    }
    @Test
    public void testInvalidEmailForm(){
        registracija.inputEmailField(Faker.instance().bothify("##??**"));
        registracija.clickEmailField();
        Assert.assertEquals(registracija.getTextNeispravanUnos(), "Neispravan unos", "Message should be visible");
    }

    @Test
    public void testShortPassword(){
        registracija.inputEmailField(Faker.instance().bothify("%%%%@####.com"));
        registracija.inputPasswordField(Faker.instance().bothify("?????"));
        registracija.clickPasswordField();
        Assert.assertEquals(registracija.getTextNeispravanUnosLozinke(), "Najmanje 6 znakova", "Message should be visible");
    }

    @Test
    public void testInvalidRepeatedPassword(){
        registracija.inputEmailField(Faker.instance().bothify("###@gmail.com"));
        registracija.inputPasswordField("asdfgh");
        registracija.inputPasswordAgainField("asdfg");
        registracija.clickUsloviCheckBox();
        Assert.assertEquals(webDriver.switchTo().alert().getText(), "Lozinka i ponovljena lozinka nisu jednake", "Alert should be visible");
    }
    @Test
    public void testNoRepeatedPassword() {
        registracija.inputEmailField(Faker.instance().bothify("%%%%@####.com"));
        registracija.inputPasswordField("asdfgh");
        registracija.clickPasswordFieldAgain();
        registracija.clickRegistriraSeFirmaCheckBox();
        Assert.assertEquals(registracija.getTextPotrebnoUpisati(), "Potrebno upisati", "Message should be visible");
    }

    @Test
    public void testUnsuccessfulRegistration() throws InterruptedException {

        registracija.inputEmailField(Faker.instance().bothify("?????####@gmail.com"));
        registracija.inputPasswordField("asdfgh");
        registracija.inputPasswordAgainField("asdfgh");
        registracija.inputNameSurnameField(Faker.instance().bothify("%%%@###&&&"));
        registracija.inputAdressField(Faker.instance().bothify("%%%%@####&&&"));
        registracija.inputCityField(Faker.instance().bothify("%%%%@####&&&"));
        registracija.selectState("Srbija");
        registracija.inputPhoneField(Faker.instance().phoneNumber().phoneNumber());
        registracija.clickUsloviCheckBox();
        registracija.inputSecurityCodeField(Faker.instance().bothify("%%%%@####&&&"));
        registracija.clickRegistracijaButton();
        Assert.assertEquals(registracija.getTextDangerAlert(), "Pogrešno ste unijeli sigurnosni kod! Molimo pokušajte ponovno.");

    }
    @AfterMethod
    public void close() {
        webDriver.close();
        webDriver.quit();
    }
}
