package techpro.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import techpro.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    // Fluent Wait ==> Belirli bir kosul gerceklesene kadar max sure boyunca,
// belittigimiz aralıklarla webelementi kontrol ederek bekler.


    @Test
    public void fluentWait() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //==> Hello World! yazısının görünürlügünü test edin

        WebElement helloWorldYazisi= driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Wait<WebDriver> wait = new FluentWait<>(driver).
                                        withTimeout(Duration.ofSeconds(30)).//fluent wait icin max bekleme suresi
                                         pollingEvery(Duration.ofSeconds(3)).//her 3 sn de bir we'i kontrol eder
                                            withMessage("Ignore Exception");//zorunlu deil hata durumunda mesaj vermek icin kullanilir
        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));
        Assert.assertTrue(helloWorldYazisi.isDisplayed());
    }
}/*
Thread.Sleep(): Javadan gelir. Belirttigimiz sure kadar kodlari bekletir.

Implicitly Wait: Selenium'dan gelir. Sayfadaki tum webelementlerin yuklenebilmesi icin max bekleme suresidir.

Explicitly Wait 2'ye ayrilir:

1.) WebDriver Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
default olarak 500ms araliklarla webelementi kontrol ederek bekler.

2.) Fluent Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
belirttigimiz araliklarla webelementi kontrol ederek bekler.
 */
