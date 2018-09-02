package EventFiring;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyTest extends EventFiring.TestBase {

    @Test
    public void firstTest() {
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys ( "selenium" + Keys.ENTER);
        wait.until(titleIs ("selenium - Поиск в Google"));
    }

    @Test
    public void secondTest() {
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys ( "selenium");
        driver.findElement(By.name("btnG")).click ();
        wait.until(titleIs ("selenium - Поиск в Google"));
    }
}

