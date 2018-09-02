package EventFiring;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println (by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println (by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println(throwable);

        System.out.println();

        File tempFile = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE);
        String path = "./target/screenshot/" + tempFile.getName();
        File screen = new File (path);
        try {
            Files.copy(tempFile, screen);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        System.out.println(screen);
    }
}
