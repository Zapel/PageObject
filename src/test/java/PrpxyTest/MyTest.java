package PrpxyTest;

import net.lightbody.bmp.core.har.Har;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyTest extends PrpxyTest.TestBase {

    @Test
    public void firstTest() {
        proxy.newHar();

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys ( "selenium" + Keys.ENTER);
        wait.until(titleIs ("selenium - Поиск в Google"));

        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
    }
}

