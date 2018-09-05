package PageObjects;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.testng.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class CustomerRegistrationTests extends TestBase {

    @Test
    @UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {

        driver.get("http://localhost/litecart/admin");
        if (driver.findElements(By.id("box-login")).size() > 0) {
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();
            wait.until((WebDriver d) -> d.findElement(By.id("box-apps-menu")));
        }

        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        Set<String> oldIds = driver.findElements(By.cssSelector("table.dataTable tr.row")).stream()
                .map(e -> e.findElements(By.tagName("td")).get(2).getText()).collect(toSet());
        System.out.println (oldIds);

        driver.get("http://localhost/litecart/en/create_account");
        driver.findElement(By.name("firstname")).sendKeys(customer.getFirstname());
        driver.findElement(By.name("lastname")).sendKeys(customer.getLastname());
        driver.findElement(By.name("address1")).sendKeys(customer.getAddress1());
        driver.findElement(By.name("postcode")).sendKeys(customer.getPostcode());
        driver.findElement(By.name("city")).sendKeys(customer.getCity());

        new Select(driver.findElement(By.name("country_code"))).selectByValue(customer.getCountry());
        //new Select(driver.findElement(By.name("zone_code"))).selectByValue(customer.getZone());

        driver.findElement(By.name("email")).sendKeys(customer.getEmail());
        driver.findElement(By.name("phone")).sendKeys(customer.getPhone());
        driver.findElement(By.name("password")).sendKeys(customer.getPassword());
        driver.findElement(By.name("confirmed_password")).sendKeys(customer.getPassword());

        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        driver.findElement(By.name ("captcha")).sendKeys(captchaVal);

        driver.findElement(By.name("create_account")).click();

        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        Set<String> newIds = driver.findElements(By.cssSelector("table.dataTable tr.row")).stream()
                .map(e -> e.findElements(By.tagName("td")).get(2).getText()).collect(toSet());
        System.out.println (newIds);

        assertTrue(newIds.containsAll(oldIds));
        assertTrue(newIds.size() == oldIds.size() + 1);
    }
}
