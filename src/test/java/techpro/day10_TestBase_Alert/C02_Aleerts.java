package techpro.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techpro.utilities.TestBase;

import java.security.Key;

public class C02_Aleerts extends TestBase {
    /*
      eger bir sayfadaki bir butona tikladigimizda bir uyari openceresi cikiyorsa ve bu cikan pencereye sag klik yapip locate alamiyorsak
      bu bir jacascrip alert tur . js alert u handle edbilmek icin driver imizi o pencereye gecirmemiz gerekir bunun icin ;
      driver objemizi kullanarak switchTo()methoduyla alert()methodunu kullnarak js alert e gecis yapmis oluruz
      accept() yada dissmis() methodlariyla  js alert u onaylar yada iptal ederek kapatmis oluruz
       */



    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().//gecmek icin kullanilan method
                alert().//alert e gecis yapar
                accept();//cikan alert'te ok yada tamam butonuna tiklar
        bekle(2);
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi="You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());


    }

    @Test
    public void dismissAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının  “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().alert().dismiss();//js alert teki iptal butonuna basar
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String istenenMetin="successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenMetin));
        bekle(2);
    }

    @Test //--> Çalışmasını istemediğimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız
    public void sendKeysAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("sinem" );
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(3);
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String istenenMesaj="sinem";
        Assert.assertTrue(resultMessage.getText().contains(istenenMesaj));
        bekle(3);




    }
}
