package odev.selenium01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class exercise02 {
 /*   1.http://zero.webappsecurity.com/ Adresine gidin
            2.Sign in butonuna basin
3.Login kutusuna “username” yazin
4.Password kutusuna “password.” yazin
5.Sign in tusuna basin(not: navigate.Back yapınız)
6.Pay Bills sayfasina gidin
7.“Purchase Foreign Currency” tusuna basin
8.“Currency” drop down menusunden Eurozone’u secin
9.“amount” kutusuna bir sayi girin
10.“US Dollars” in secilmedigini test edin
11.“Selected currency” butonunu secin
12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

  */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() {
     driver.findElement(By.xpath("//button[@id='signin_button']")).click();
     driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
     driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("password.");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     driver.navigate().back();

    }



}
