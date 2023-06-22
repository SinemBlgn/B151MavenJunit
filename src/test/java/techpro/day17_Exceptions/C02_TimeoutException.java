package techpro.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techpro.utilities.TestBase;

import java.time.Duration;

public class C02_TimeoutException extends TestBase {
    @Test
    public void TimeoutException() {
        /*
TimeOutException:

sayfada aradıgımız elementi wait ile belirttigimiz max. sürede
bulamadıgı durumda TimeOutException hatası alırız.

 */

        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz


        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //searchBox görünür oluncaya kadar bekleyiniz


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));


       WebElement searchBox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));


       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */

/*
     NoSuchElementException:
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementle

            Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada
fluent wait kullaniriz
     */

    }

    @Test
    public void TimeoutException02() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
// Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();
// Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        visibleWait(helloWorld,100);

        Assert.assertTrue(helloWorld.isDisplayed());

        //HATALI KOD
        //Duration.ofSeconds(1); ortalama 6 sn geciyor ancak 1 sn yazdik. Hata verecektir.

    }
}

