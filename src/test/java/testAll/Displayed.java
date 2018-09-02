package testAll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import parallel.TestBase;

public class Displayed extends TestBase{
    @Test
    public void displayed() {
        WebElement error = null;

        driver.get("https://accounts.ukr.net/registration");

        WebElement element = driver.findElement( By.id("id-login"));
        element.sendKeys ("@");

        try {
            error = driver.findElement( By.xpath ("/html/body/div[1]/div/main/form/section[1]/div/p"));
        } catch (NoSuchElementException e) {
            System.out.println (e);
        }

        if (error.isDisplayed ()) {
            String value = error.getAttribute("outerHTML");
            System.out.println("outerHTML: " + value);

            String text = error.getText();
            System.out.println("text: " + text);
        }
    }
}
