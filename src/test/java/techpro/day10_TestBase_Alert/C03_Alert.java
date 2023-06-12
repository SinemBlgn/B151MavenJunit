package techpro.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techpro.utilities.TestBase;

public class C03_Alert extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
    //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        Assert.assertEquals("You clicked a button",getTextalert());
        bekle(2);
      //Ve alert'ü kapatalım
        acceptAlert();
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptale basalım.
        dismissAlert();
        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonucyazisi=driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucyazisi);
    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);
//çıkan alerte ismimizi girelim
        sendkeysalert("sinem");
        bekle(2);
        acceptAlert();
//ismi girdiğimizi doğrulayalım
        String sonucYazisi=driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("sinem"));
    }
}
