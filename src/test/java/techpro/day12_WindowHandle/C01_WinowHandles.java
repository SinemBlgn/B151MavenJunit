package techpro.day12_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techpro.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WinowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//  ilk sayfasının Handle degerini alın yazdırın
      String handle1 =driver.getWindowHandle();
        System.out.println("ikl sayfanin handle degeri"+handle1);
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String acualText=driver.findElement(By.xpath("//h3")).getText();

        String expectedText="Opening a new window";

        Assert.assertEquals(expectedText,acualText);
//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);
/*
Bir button'a click yaptigimizda kontrolümüz disinda yeni bir sekme yada pencere acilirsa
yeni acilan pencerinin handle degerini bilmedigi icin normal getWindowHandle ile driver'imi
yeni pencereye gecerimem, bunun icin getWindowHandles() methoduyla acilan tum pencereleri bir
Set'e  assign ederiz
 methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
    mantigiyla bir loop icinde cozebiliriz
 */
        Set<String> pencereler=driver.getWindowHandles();
        for (String  w:pencereler){
            System.out.println(w);
            if (!w.equals(handle1)){
                driver.switchTo().window(w);
            }
        }

//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualNewWindow=driver.getTitle();
        String expectedNewWindow="New Window";
        Assert.assertEquals(expectedNewWindow,actualNewWindow);
        String ikinciSayfaHandle=driver.getWindowHandle();
        System.out.println(ikinciSayfaHandle);



//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(handle1);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);
//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(handle1);
        bekle(2);
    }

    @Test
    public void tets02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Opening a new window"));

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));

        /*
            getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir arrayList'e atadik.
            Index (0)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan driver.switchTo().window(pencereler.get(1));
            ile yeni acilan pencereye gecis yaptik
         */

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));

    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.

        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.

        bekle(2);
        //  ilk sayfaya tekrar dönün.

        bekle(2);
    }
}
