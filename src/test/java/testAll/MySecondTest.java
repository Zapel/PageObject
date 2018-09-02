package testAll;

import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MySecondTest extends TestBase {

    @Test
    public void  myFirstTest() {
        driver.get ("http://www.google.com");
        WebElement field = driver.findElement(By.name("q"));
        //driver.navigate().refresh ();
        field.sendKeys("selenium");
        field.sendKeys(Keys.ENTER);
        wait.until (titleIs( "selenium - Поиск в Google" ));

        WebElement element = driver.findElement (By.cssSelector(".rc"));
        System.out.println("element: " + element.getTagName());
        assertTrue(isElementPresent(By.cssSelector(".rc")));
    }

    @Test
    public void MySecondTest() {
        driver.get ("http://www.ukr.net");
        driver.findElement (By.name("Login")).sendKeys ("zapel176");
        driver.findElement (By.name ("Password")).sendKeys("170678");
        driver.findElement (By.name ("Password")).sendKeys(Keys.ENTER);
    }
}
