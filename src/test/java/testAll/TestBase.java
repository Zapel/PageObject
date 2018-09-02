package testAll;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestBase {
    public static ThreadLocal<WebDriver> tlDriwer = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (tlDriwer.get () != null) {
            driver = tlDriwer.get ();
            wait = new WebDriverWait (driver, 10);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return;
        }

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences ();
        logPrefs.enable( LogType.PERFORMANCE, Level.ALL);
        cap.setCapability( CapabilityType.LOGGING_PREFS, logPrefs);

        //driver = new FirefoxDriver();
        driver = new ChromeDriver(cap);
        tlDriwer.set(driver);
        wait = new WebDriverWait (driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook (new Thread(() -> {driver.quit();
            driver = null;}));
    }

    @After
    public void stop() {
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresentClearly(By locator) {
        try {
            wait.until((WebDriver driver) -> driver.findElement(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
