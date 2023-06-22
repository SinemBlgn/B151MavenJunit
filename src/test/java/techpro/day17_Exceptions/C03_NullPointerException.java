package techpro.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import techpro.utilities.TestBase;

public class C03_NullPointerException extends TestBase {



        /*
        NullPointerException:

        degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde
        NullPointerException hatasi aliriz.
                */
        WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;


    @Test
    public void NullPointerExceptionTest1() {
        // driver = new ChromeDriver(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
        driver.get("https://amazon.com");
    }

    @Test
    public void NullPointerException2() {
        System.out.println(faker.name().firstName());
        //faker= new Faker(); atamasini yapmadigimiz icin NullPointerException hatasini aldik

    }

    @Test
    public void NullPointerException3() {
        System.out.println(sayi + 5);
    }

    @Test
    public void NullPointerExceptionTest4() {
        // sayi=6; sayi degiskenine atama yapmadıgımız icin NullPointerException hatası aldık.
        System.out.println(sayi+5);

    }


    @Test
    public void NullPointerExceptionTest5() {
        // isim="Burak"; isim degiskenine atama yapıladıgı icin NullPointerException hatası aldık.
        System.out.println(isim.charAt(0));
    }
//HATALI KODLAR
}
