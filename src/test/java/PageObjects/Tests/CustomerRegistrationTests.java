package PageObjects.Tests;

import PageObjects.Model.Customer;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import static org.testng.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class CustomerRegistrationTests extends TestBase {

    @Test
    @UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {
        Set<String> oldIds = app.getCustomerIds();
        System.out.println(oldIds);

        app.registerNewCustomer(customer);

        Set<String> newIds = app.getCustomerIds();
        System.out.println(newIds);

        assertTrue(newIds.containsAll(oldIds));
        assertTrue(newIds.size() == oldIds.size() + 1);
    }
}
