package techpro.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    /*
    drpodown --->alt basliklarin oldugu acilir menu listesidir
    dropdown u handle etmek icin :
    1)dropdown menuyu ilkolarak locate ederiz
    2)select objesi olustururuz
    3)select objesinin dropdown menu webelementi nin icerigine ve seceneklerine erisim saglamasi icin selct sinifina arguman olarak locate ettigimiz
    webelementi koyariz
    SYNTAX:
    Select select=new Select(ddm webelement)
    4)select classi sadece <select> tag i ile olustrurlmus dropdown menulere uygulanabilir
    5)select objesi dropdown menuyu handle edebilmek icin 3 method kullanir
         --selectByVisbleText()->dropdown nda ki elemente gorunur metin ile ulasmak icin kullanilir
         --selectByIndex() ->index ile ulasmak icin kullanilir (index 0(sifir) dan baslar)
         --selectByValue -->element in degeri ile ulasmak icin kullanilir (option taglarindaki deger ile )
    6)getOptions()->locate ettigimiz dd menu de ki tum secenekelri bize verir (list e atip loop ile yazdirabiliriz)
    7)getFirstSelectedOption()-->dd deki secili kalan secenegi bize verir birden fazla secenek secildiyse
    bu secilenlerin ilkini verir

     */



    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
   WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }


    @Test
    public void test01() {
       // 1.Method:
      //  a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil=driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay=driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun=driver.findElement(By.xpath("(//select)[4]"));

      //  b. Select objesi olustur
        Select select =new Select(yil);
        //  c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);//index 0 dan baslar 2018i secer

        Select select1=new Select(ay);
        select1.selectByValue("6");

        Select select2=new Select(gun);
        select2.selectByVisibleText("15");


    }

    @Test
    public void test02() {
      //  2.Method:
       // a. Tüm eyalet isimlerini yazdıralım
        //1.yol:(select ile)
        WebElement eyaletler=driver.findElement(By.xpath("(//select)[5]"));
        Select select= new Select(eyaletler);
        select.getOptions().forEach(w-> System.out.println(w.getText()));
        //2.yol

        System.out.println("**************2.yol**********************");
        List<WebElement> eyalet=driver.findElements(By.xpath("(//select)[5]"));
        eyalet.forEach(w-> System.out.println(w.getText()));

    }

    @Test
    public void test03() {
      //  3.Method:
       // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim/

        WebElement eyaletler=driver.findElement(By.xpath("(//select)[5]"));
        Select select=new Select(eyaletler);
        String seciliOlanSecenek=select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",seciliOlanSecenek);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
