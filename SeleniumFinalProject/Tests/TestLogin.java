package SeleniumFinalProject.Tests;


import SeleniumFinalProject.Pages.HomePage;
import SeleniumFinalProject.Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class TestLogin {
    private WebDriver webDriver;
    private HomePage homePage;
    private Login login;

    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new SeleniumFinalProject.Pages.HomePage(webDriver);
        login = new SeleniumFinalProject.Pages.Login(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/");
    }

    @Test
    public void testValidAccountLogin() {
        homePage.clickPrijavaNavBar();
        login.inputEmailField((Faker.instance().bothify("?????####@gmail.com")));
        login.inputLozinkaField(Faker.instance().bothify("??????????"));
        login.clickPrijava();
        Assert.assertEquals("https://www.knjizara-harfa.rs/", "https://www.knjizara-harfa.rs/");
    }

    @Test(dataProvider = "invalidUsers")
    public void testInvalidAccountLogin(String email, String password) {
        homePage.clickPrijavaNavBar();
        login.inputEmailField(email);
        login.inputLozinkaField(password);
        login.clickPrijava();
        Assert.assertTrue(login.getTextLoginExistingUserIncorrectEmailOrPassword().contains("Pogrešno upisana e-mail adresa ili lozinka!"));
    }
    @DataProvider(name = "invalidUsers")
    public Object[][] getInvalidUserNamesAndPasswords() {
        return new Object[][]{
                {"test1@test.com", "password1"},
                {"test2@test.com", "password2"},
                {"test3@test.com", "password3"},
        };
    }

    @AfterMethod
    public void close() {
        webDriver.close();
        webDriver.quit();
    }
}
