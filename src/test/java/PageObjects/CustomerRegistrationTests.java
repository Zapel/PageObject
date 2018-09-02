package PageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerRegistrationTests extends TestBase {
    @Test
    public void canRegisterCustomer() {
        Customer customer = new Customer.Builder()
                .setFirstname("Adam").setLastname("Smith").setAdress1("Hidden Place")
                .setPostcode("12345").setCity("New City").setCountry("US").setZone("KS")
                .setEmail("adam"+System.currentTimeMillis()+"@smith.me")
                .setPhone("+0123456789").setPassword("qwerty").build();

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
