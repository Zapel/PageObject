package testAll;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import parallel.TestBase;

public class GetAttributeTest extends TestBase{
    @Test
    public void attribute() {
        driver.get("http://www.google.com");

        WebElement element = driver.findElement( By.name("btnK"));
        String attribute = element.getAttribute("outerHTML");
        System.out.println("attribute: " + attribute);
        System.out.println ();
    }

    @Test
    public void attributeField() {
        driver.get("http://www.google.com");

        WebElement element = driver.findElement( By.name("q"));
        element.sendKeys ("selenium");

        String attributeValue = element.getAttribute("value");
        System.out.println("value: " + attributeValue);
        System.out.println ();

        String attributeText = element.getText();
        System.out.println("text: " + attributeText);
    }

    @Test
    public void attributeLink() {
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/div[1]/div[1]/a"));

        String attributeHref = element.getAttribute("href");
        System.out.println("href: " + attributeHref);
        System.out.println ();
    }

    @Test
    public void attributeText() {
        driver.get("http://www.google.com");

        WebElement element = driver.findElement( By.name("q"));
        element.sendKeys ("selenium");

        String attributeTextContent = element.getAttribute("textContent");
        System.out.println("textContent: " + attributeTextContent);
    }
}
