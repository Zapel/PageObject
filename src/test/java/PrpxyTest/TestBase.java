package PrpxyTest;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;
    public BrowserMobProxy proxy;

    @Before
    public void start() {
        // start the proxy
        proxy = new BrowserMobProxyServer ();
        proxy.start(0);
        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( CapabilityType.PROXY, seleniumProxy);

        driver = new ChromeDriver(capabilities);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook (new Thread(() -> {driver.quit();
            driver = null;}));
    }

    @After
    public void stop() {
    }
}
