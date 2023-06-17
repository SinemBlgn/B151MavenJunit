package techpro.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techpro.utilities.TestBase;

import javax.swing.*;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //google anasayfasina gidelim
        driver.get("https://www.google.com");
        //arama kutusuna shift tusunu basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//arama kutusunda shift tusla bastik
        sendKeys("selenium").//shift basili oldugu icin buyuk yazdi
                keyUp(Keys.SHIFT).//shift tusunu serbest birak
                sendKeys("-java",Keys.ENTER).perform();//shift i biraktigimiz icin kucuk yazdi


        /*
keyDown(aramaKutusu, Keys.SHIFT) arama kutusunda shifte bastik--sendKeys("selenium") selenium yazdik
--keyUp(Keys.SHIFT) shift biraktik--sendKeys("java", Keys.ENTER) java yazdik, arattik
--perform(); ile actions i sonlandirdik
NOT: shift tusu basili tutuldugunda yaziyi büyük harflerle yazar

 */
    }

    @Test
    public void test02() {

        //google anasayfasina gidelim
        driver.get("https://www.google.com");
        //arama kutusuna shift tusunu basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        /*
Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
         */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://www.google.com");
// Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("selenium",Keys.ENTER);
// Sayfayı bekleyin
        bekle(3);
// Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(Keys.CONTROL,"a");
        bekle(3);
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(Keys.CONTROL,"x");
        bekle(3);
        /*
        sayfa yenilendigi icin tekrar locate aldik
         */
//Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(Keys.CONTROL,"v",Keys.ENTER);


    }
}
