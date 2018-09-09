package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Application {
    private WebDriver driver;
    private WebDriverWait wait;

    private RegistrationPage registrationPage;
    private final AdminPanelLoginPage adminPanelLoginPage;
    private CustomerListPage customerListPage;

    public Application() {
        driver = new ChromeDriver();
        wait = new WebDriverWait (driver, 10);

        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
    }

    public void quit() {
        driver.quit ();
    }

    void registerNewCustomer(Customer customer) {
        registrationPage.open();
        registrationPage.firstnameInput().sendKeys(customer.getFirstname());
        registrationPage.lastnameInput().sendKeys(customer.getLastname());
        registrationPage.address1Input().sendKeys(customer.getAddress1());
        registrationPage.postcodeInput().sendKeys(customer.getPostcode());
        registrationPage.cityInput().sendKeys(customer.getCity());

        new Select (driver.findElement(By.name("country_code"))).selectByValue(customer.getCountry());
        //new Select(driver.findElement(By.name("zone_code"))).selectByValue(customer.getZone());

        registrationPage.emailInput().sendKeys(customer.getEmail());
        registrationPage.phoneInput().sendKeys(customer.getPhone());
        registrationPage.passwordInput().sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput().sendKeys(customer.getPassword());

        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        driver.findElement(By.name ("captcha")).sendKeys(captchaVal);

        registrationPage.createAccountButton().click();
    }

    public Set<String> getCustomerIds() {
        driver.get("http://localhost/litecart/admin");
        if (driver.findElements(By.id("box-login")).size() > 0) {
            driver.findElement ( By.name ( "username" ) ).sendKeys ( "admin" );
            driver.findElement ( By.name ( "password" ) ).sendKeys ( "admin" );
            driver.findElement ( By.name ( "login" ) ).click ();
            wait.until ( (WebDriver d) -> d.findElement ( By.id ( "box-apps-menu" ) ) );
        }

        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        return driver.findElements(By.cssSelector("table.dataTable tr.row")).stream()
                .map(e -> e.findElements(By.tagName("td")).get(2).getText()).collect(toSet());
    }
}