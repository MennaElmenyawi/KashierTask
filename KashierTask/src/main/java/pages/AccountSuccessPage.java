package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountSuccessPage {
    private final WebDriver driver;

    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
    }


    public void assertAccountCreatedSuccessfully() {
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://merchant.kashier.io/en/signup");
        }
    public void assertAccountNotCreated() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://merchant.kashier.io/en/signup");
        }
}