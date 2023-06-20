package techpro.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

    public class C01_FileExist {


        @Test
        public void fileExist() {

            System.out.println(System.getProperty("user.dir"));  //  C:\Users\BURAK\IdeaProjects\B151MavenJUnit
            // bana icinde oldugum projenin dosya yolunu(path) verir.


            System.out.println(System.getProperty("user.home"));  // C:\Users\BURAK
            // herkesin bilgisayarında farklı olan kısmı verir.



            // SORU:
            // Desktop(masaustu)'da bir text dosyası olusturun



            // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        dosyanın,bilgisayarımda destop'da olup olmadıgını
        Java ile test edecegim.
        cunku selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki desktop'a mudahele edemez
         */

            //    "C:\Users\BURAK\Desktop\text.txt"
            Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Desktop\\text.txt")));

            // daha dinamik hale getirelim


            //    "C:\Users\BURAK              \Desktop\text.txt"

            String farkliKisim = System.getProperty("user.home");  // herkesin bilgisayarında farklı olan kısımdır
            String ortakKisim = "\\Desktop\\text.txt";             // herkesin bilgisayarında ortak olan kısımdır

            String dosyaYolu = farkliKisim + ortakKisim;          // dosya yolu olarak farklı kısım ve ortak kısımı aldık


            Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        }
    }


