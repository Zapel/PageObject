package testAll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CustomerRegistrationTests2 extends testAll.TestBase {

    @Test
    public void canRegisterCustomer() {
        driver.get("http://localhost/litecart/admin");
        if (driver.findElements(By.id("box-login")).size() > 0) {
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin" + Keys.ENTER);
            wait.until((WebDriver d) -> d.findElement(By.id("box-apps-menu")));
        }
    }
}
