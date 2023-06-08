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

public class C03_Dropdown {
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
        WebElement diller=driver.findElement(By.xpath("(//select)[6]"));
        Select select=new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //eger sadece secili olanlari yazdirmak istersek ;
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));
        System.out.println("*************************************");
        for (WebElement w:select.getAllSelectedOptions()){
            System.out.println(w.getText());
        }//seceneklerden 4 tane sectiginizi dogrulayin
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //sectigimiz seceneklerden ilkini yazdiralim
        System.out.println("secilen secenekleren ilki:");
        System.out.println(select.getFirstSelectedOption().getText());

        //Sectigimiz seceneklerin hepsini kaldiralim
        select.deselectAll();

        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
        diller.sendKeys("C#");

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectVisibleText(diller,"Java");
        //Index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectIndex(diller,2);
        bekle(2);

        //Value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectValue(diller,"js");


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectVisibleText(WebElement ddm,String secenek){
        Select select=new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

}
