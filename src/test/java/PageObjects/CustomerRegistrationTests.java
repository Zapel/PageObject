package PageObjects;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

@RunWith(DataProviderRunner.class)
public class CustomerRegistrationTests extends TestBase {

    @Test
    @UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {
        driver.get("http://localhost/litecart/en/create_account");
        driver.findElement(By.name("firstname")).sendKeys(customer.getFirstname());
        driver.findElement(By.name("lastname")).sendKeys(customer.getLastname());
        driver.findElement(By.name("address1")).sendKeys(customer.getAddress1());
        driver.findElement(By.name("postcode")).sendKeys(customer.getPostcode());
        driver.findElement(By.name("city")).sendKeys(customer.getCity());

        new Select(driver.findElement(By.name("country_code"))).selectByValue(customer.getCountry());
        new Select(driver.findElement(By.name("zone_code"))).selectByValue(customer.getZone());

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div/form/div[6]/div[1]/div/input")).sendKeys(customer.getEmail());
        driver.findElement(By.name("phone")).sendKeys(customer.getPhone());
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div/form/div[7]/div[1]/div/input")).sendKeys(customer.getPassword());
        driver.findElement(By.name("confirmed_password")).sendKeys(customer.getPassword());
        driver.findElement(By.name("create_account")).click();
    }
}
