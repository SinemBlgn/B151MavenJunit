package techpro.day16_Wait;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techpro.utilities.TestBase;

import java.time.Duration;

public class C02_ExpilicitWait extends TestBase {
    public void expilicitWait() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //==> Hello World! yazısının görünürlügünü test edin

        WebElement helloWorldYazisi= driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        visibleWait(helloWorldYazisi,100);
       // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));
        // WebElement hellowordYazisi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']"))); locate ile
        Assert.assertTrue(helloWorldYazisi.isDisplayed());
    }
}
