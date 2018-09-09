package PageObjects.App;

import PageObjects.Model.Customer;
import PageObjects.Page.AdminPanelLoginPage;
import PageObjects.Page.CustomerListPage;
import PageObjects.Page.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Set;

public class Application {
    private WebDriverWait wait;
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private AdminPanelLoginPage adminPanelLoginPage;
    private CustomerListPage customerListPage;

    public Application() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void registerNewCustomer(Customer customer) {
        registrationPage.open();
        registrationPage.firstnameInput.sendKeys(customer.getFirstname());
        registrationPage.lastnameInput.sendKeys(customer.getLastname());
        registrationPage.address1Input.sendKeys(customer.getAddress1());
        registrationPage.postcodeInput.sendKeys(customer.getPostcode());
        registrationPage.cityInput.sendKeys(customer.getCity());

        registrationPage.selectCountry(customer.getCountry());
        //new Select (driver.findElement(By.name("country_code"))).selectByValue(customer.getCountry());
        //new Select(driver.findElement(By.name("zone_code"))).selectByValue(customer.getZone());
        registrationPage.emailInput.sendKeys(customer.getEmail());
        registrationPage.phoneInput.sendKeys(customer.getPhone());
        registrationPage.passwordInput.sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());

        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        driver.findElement(By.name ("captcha")).sendKeys(captchaVal);

        registrationPage.createAccountButton.click();
    }

    public Set<String> getCustomerIds() {
        if(adminPanelLoginPage.open().isOnThisPage()) {
            adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
        }
        return customerListPage.open().getCustomerIds();
    }
}
