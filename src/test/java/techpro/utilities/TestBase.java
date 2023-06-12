package techpro.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    /*
    testbase clasindan obje olusturmanin onune gecmek icin bu class i abstract yapabiliriz
    bu classa extends yaptigimiz test classlarindan ulasabilirz

     */
   protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {

 driver.quit();
    }
    //hard wait (bekleme modu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //acceptAllert()
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //dismisAllert()
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    //getTextAlert()
    public String getTextalert(){
      return  driver.switchTo().alert().getText();


    }
    //sendkeysalert()
    public void sendkeysalert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }



}
