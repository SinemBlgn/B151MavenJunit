package techpro.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
 /*Bir testte sadece arama yapilacak veya gorunurluk sorgulanacaksa (cikan urune click yapmamak kaydiyla) before ve after methodlari yerine
        beforeclass ve afterclass methodlari kullanildiginda tek browser'da tum methodlari test etmis oluruz

  */

public class C01_ClassWork {
  static   WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @Test
    public void titleTest() {
        //  ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void imageTest() {
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
    }
    @Test
    public void searchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searhBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searhBox.isEnabled());
    }
    @Test
    public void wrongtitleTest() {
        //○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }


}
