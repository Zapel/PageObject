package testAll;

import org.junit.Test;
import org.openqa.selenium.logging.LogEntry;

public class BrowserLogs extends TestBase {
    @Test
    public void getBrowserLogs() {
        driver.navigate().to("http://selenium2.ru");
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        driver.manage().logs().get("performance").forEach(l -> System.out.println(l));

        for(LogEntry l : driver.manage().logs().get("driver").getAll ()) {
            System.out.println(l);
        }
    }
}
