package PageObjects.Tests;

import PageObjects.App.Application;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    public Application app = new Application();

    @Before
    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {app.quit();
                                                                 app = null;}));
    }

    @After
    public void stop() {
    }
}
