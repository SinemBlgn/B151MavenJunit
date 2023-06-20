package techpro.day16_Wait;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techpro.utilities.TestBase;

public class C04_ExpilicitWait extends TestBase{

    @Test
    public void test01() {
        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //==>  "It's gone!" yazısının görünür oldugunu test edin.
        WebElement yazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
