package testAll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys ( "selenium" + Keys.ENTER);
        wait.until(titleIs ("selenium - Поиск в Google"));

        WebElement element = driver.findElement (By.cssSelector(".rc"));
        System.out.println("element: " + element.getTagName());
        assertTrue(isElementPresentClearly(By.cssSelector(".rc")));

        Cookie cookie = new Cookie ( "key", "value" );
        driver.manage().addCookie(cookie);

        Set<Cookie> allCookies = driver.manage ().getCookies();
        for (Cookie loadedCookie : allCookies) {
            System.out.println(String.format("%s -> %s", loadedCookie.getName(),loadedCookie.getValue()));
        }
    }
}

