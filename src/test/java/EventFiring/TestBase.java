package EventFiring;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase extends MyListener{
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new EventFiringWebDriver(new ChromeDriver ());
        ((EventFiringWebDriver)driver).register(new MyListener());
        wait = new WebDriverWait (driver, 10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook (new Thread(() -> {driver.quit();
            driver = null;}));
    }

    @After
    public void stop() {
    }
}
