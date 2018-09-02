package parallel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MySecondTest extends TestBase {

    @Test
    public void  myFirstTest() {
        driver.get ("http://www.google.com");
        WebElement field = driver.findElement(By.name("q"));
        field.sendKeys("selenium");
        field.sendKeys( Keys.ENTER);
        wait.until (titleIs( "selenium - Поиск в Google" ));
    }

    @Test
    public void  mySecondTest() {
        driver.get ("http://www.google.com");
        WebElement field = driver.findElement(By.name("q"));
        field.sendKeys("selenium");
        field.sendKeys( Keys.ENTER);
        wait.until (titleIs( "selenium - Поиск в Google" ));
    }

    @Test
    public void  myThirdTest() {
        driver.get ("http://www.google.com");
        WebElement field = driver.findElement(By.name("q"));
        field.sendKeys("selenium");
        field.sendKeys( Keys.ENTER);
        wait.until (titleIs( "selenium - Поиск в Google" ));
    }
}
