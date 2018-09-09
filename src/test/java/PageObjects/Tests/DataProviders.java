package PageObjects.Tests;

import PageObjects.Model.Customer;
import com.tngtech.java.junit.dataprovider.DataProvider;

public class DataProviders {
    @DataProvider
    public static Object[][] validCustomers() {
        return new Object[][]{
                {new Customer.Builder ()
                        .setFirstname("Adam").setLastname("Smith").setAdress1("Hidden Place")
                        .setPostcode("12345").setCity("New City").setCountry("UA" ).setZone("KS")
                        .setEmail("adam" + System.currentTimeMillis() + "@smith.me")
                        .setPhone("+0123456789").setPassword("qwerty").build()},
        };
    }
}
