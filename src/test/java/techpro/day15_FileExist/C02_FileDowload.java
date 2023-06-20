package techpro.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techpro.utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowload extends TestBase {
    //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
    //"b10 all test cases" dosyasını indirin
    // Dosyanın başarıyla indirilip indirilmediğini test edin.


    @Test
    public void name() {

        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

        //   C:\Users\BURAK\Downloads\b10 all test cases, code.docx
        File silinecekDosya = new File("C:\\Users\\BURAK\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        /*
        File silinecekDosya = new File("C:\\Users\\BURAK\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        Eger localinizden otomasyon ile bir dosya silmek icin File class'ından obje olusturup dosya yolunuzu
        içine yerlestiririz. Ve olusturdugumuz obje ile delete() methodunu kullanarak o dosyayı silebiliriz.

        Bunu yapma sebebimiz test class'ımızı çalıstırdıgımızda, her calıstırmada yeni bir dosya indirecegi icin
        ordaki dosya kalabalıgını önlemiş oluruz. aynı zamanda dogrulama yaparken işimizi garantiye almış oluruz.

        Aynı isimde birden fazla dosya indirmis olsak da her indirilenin yanına index verecegi icin ve bizim ilk indirdigimiz
        o klasörün icinde bulamayacagı icin her zaman ilk dosyanın varlıgı test etmis oluruz.



         */







        //"b10 all test cases" dosyasını indirin

        WebElement indirilecekDosya = driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
        indirilecekDosya.click();

        bekle(5);



        // Dosyanın başarıyla indirilip indirilmediğini test edin.


        /*
        dosyanın, bilgisayarımda dowloads'a basarıyla indirilip indirilmedigini
        java ile test edecegim.
        cünkü selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki dowloads'a müdahele edemez.
         */


        //      "C:\Users\BURAK           \Downloads\b10 all test cases, code.docx"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Downloads\\b10 all test cases, code.docx")));


        // daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

}
