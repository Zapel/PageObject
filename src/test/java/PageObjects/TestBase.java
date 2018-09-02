package PageObjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static ThreadLocal<WebDriver> tlDriwer = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (tlDriwer.get () != null) {
            driver = tlDriwer.get ();
            wait = new WebDriverWait (driver, 10);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return;
        }
        driver = new ChromeDriver();
        tlDriwer.set(driver);
        wait = new WebDriverWait (driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook (new Thread(() -> {driver.quit();
                                                                 driver = null;}));
    }

    @After
    public void stop() {
    }
}
