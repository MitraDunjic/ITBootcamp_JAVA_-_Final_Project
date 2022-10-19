package SeleniumFinalProject.Tests;

import SeleniumFinalProject.Pages.HomePage;
import SeleniumFinalProject.Pages.KnjigeKojeVoleInspirisati;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;

public class TestKnjigeKojeVoleInspirisati {
    private WebDriver webDriver;
    private HomePage homePage;

    private KnjigeKojeVoleInspirisati knjigeKojeVoleInspirisati;


    @BeforeMethod
    public void configure() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        homePage = new SeleniumFinalProject.Pages.HomePage(webDriver);
        knjigeKojeVoleInspirisati = new KnjigeKojeVoleInspirisati(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.knjizara-harfa.rs/");
        homePage.clickToKnjizara();
        homePage.hoverToKnjigeKojeVoleInspirisati();
        homePage.clicknjigeKojeVoleInspirisati();
    }

    @Test
    public void listaCena() {
        ArrayList<String> expectedCene = new ArrayList<String>();
        expectedCene.add("1.950,00 din");
        expectedCene.add("1.450,00 din");
        expectedCene.add("1.750,00 din");
        expectedCene.add("1.750,00 din");
        expectedCene.add("1.450,00 din");
        expectedCene.add("1.750,00 din");
        Assert.assertEquals(expectedCene, knjigeKojeVoleInspirisati.getSveCene());
    }

    @Test
    public void sortCenaMaxMin() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        knjigeKojeVoleInspirisati.clickSortInput();
        knjigeKojeVoleInspirisati.clickBookSortByValue(webDriver, "Cena (više > niže)");
        knjigeKojeVoleInspirisati.getSveCene();
        ArrayList<String> expectedSortCenaMaxMin = new ArrayList<String>();
        expectedSortCenaMaxMin.add("1.950,00 din");
        expectedSortCenaMaxMin.add("1.750,00 din");
        expectedSortCenaMaxMin.add("1.750,00 din");
        expectedSortCenaMaxMin.add("1.750,00 din");
        expectedSortCenaMaxMin.add("1.450,00 din");
        expectedSortCenaMaxMin.add("1.450,00 din");
        Assert.assertEquals(knjigeKojeVoleInspirisati.getSveCene(), expectedSortCenaMaxMin);
    }

    @Test
    public void sortCenaMinMax() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        knjigeKojeVoleInspirisati.clickSortInput();
        knjigeKojeVoleInspirisati.clickBookSortByValue(webDriver, "Cena (niže > više)");
        knjigeKojeVoleInspirisati.getSveCene();
        ArrayList<String> expectedSortCenaMaxMin = new ArrayList<String>();
        expectedSortCenaMaxMin.add("1.450,00 din");
        expectedSortCenaMaxMin.add("1.450,00 din");
        expectedSortCenaMaxMin.add("1.750,00 din");
        expectedSortCenaMaxMin.add("1.750,00 din");
        expectedSortCenaMaxMin.add("1.750,00 din");
        expectedSortCenaMaxMin.add("1.950,00 din");
        Assert.assertEquals(expectedSortCenaMaxMin,knjigeKojeVoleInspirisati.getSveCene());
    }
    @Test
    public void sortNasloviAZ() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        knjigeKojeVoleInspirisati.clickSortInput();
        knjigeKojeVoleInspirisati.clickBookSortByValue(webDriver, "Naslov (A - Ž)");
        knjigeKojeVoleInspirisati.getSviNaslovi();
        ArrayList<String> expectedNasloviAZ = new ArrayList<String>();
        expectedNasloviAZ.add("ČETIRI VREDNOSTI koje će decu pratiti do kraja života");
        expectedNasloviAZ.add("SAČUVATI LJUBAV - Porodici su potrebni roditelji koji više misle na sebe");
        expectedNasloviAZ.add("SUPERMOĆNI Transformišite anksioznost u hrabrost, samopouzdanje i otpornost");
        expectedNasloviAZ.add("SVESNI RODITELJI menjamo sebe, osnažujemo svoju decu");
        expectedNasloviAZ.add("UNUTRAŠNJI SVET RODITELJSTVA Kako vam dublje razumevanje samoga sebe može pomoći da vaspitate uspešnu decu");
        expectedNasloviAZ.add("ŽIVETI SVESNO, Nauka i praksa prisutnosti");
        Assert.assertEquals(expectedNasloviAZ,knjigeKojeVoleInspirisati.getSviNaslovi());
    }

    @Test
    public void sortNasloviZA() throws InterruptedException {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        knjigeKojeVoleInspirisati.clickSortInput();
        knjigeKojeVoleInspirisati.clickBookSortByValue(webDriver, "Naslov (Ž - A)");
        knjigeKojeVoleInspirisati.getSviNaslovi();
        ArrayList<String> expectedNasloviAZ = new ArrayList<String>();
        expectedNasloviAZ.add("ŽIVETI SVESNO, Nauka i praksa prisutnosti");
        expectedNasloviAZ.add("UNUTRAŠNJI SVET RODITELJSTVA Kako vam dublje razumevanje samoga sebe može pomoći da vaspitate uspešnu decu");
        expectedNasloviAZ.add("SVESNI RODITELJI menjamo sebe, osnažujemo svoju decu");
        expectedNasloviAZ.add("SUPERMOĆNI Transformišite anksioznost u hrabrost, samopouzdanje i otpornost");
        expectedNasloviAZ.add("SAČUVATI LJUBAV - Porodici su potrebni roditelji koji više misle na sebe");
        expectedNasloviAZ.add("ČETIRI VREDNOSTI koje će decu pratiti do kraja života");
        Assert.assertEquals(expectedNasloviAZ,knjigeKojeVoleInspirisati.getSviNaslovi());
    }
        @AfterMethod
        public void close () {
            webDriver.close();
            webDriver.quit();
        }
    }

