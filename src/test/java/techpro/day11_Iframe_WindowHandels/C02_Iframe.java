package techpro.day11_Iframe_WindowHandels;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techpro.utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void iframe() {
         //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
          //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
       String metin= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(metin.contains("Editor"));
         //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textbox=driver.findElement(By.xpath("//p"));
        textbox.clear();
        bekle(2);

       //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır.");
        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
      WebElement elementelSeleniumLinke=driver.findElement(By.xpath("(//a)[3]"));
      Assert.assertTrue(elementelSeleniumLinke.isDisplayed());
    }
}
