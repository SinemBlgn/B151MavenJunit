package techpro.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techpro.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        //3 saniye bekle
        bekle(3);
        //basligin Bootcamp icerdigini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
