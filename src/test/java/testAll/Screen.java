package testAll;

import com.google.common.io.Files;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Screen extends TestBase {
    @Test
    public void screenTest() {
        driver.get("http://www.google.com");

        WebElement field = driver.findElement(By.name("q"));
        field.sendKeys("selenium");
        field.sendKeys( Keys.ENTER);

        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshot/" + tempFile.getName();
        File screen = new File (path);
        try {
            Files.copy(tempFile, screen);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        System.out.println (screen);
    }
}
