package techpro.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techpro.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void NoSuchElementException() {
         /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
         */


        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz


        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //arama kutusuna java yazip aratin
        driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).
                sendKeys("Java" + Keys.ENTER);

//HATALI KOD



    }
    }

