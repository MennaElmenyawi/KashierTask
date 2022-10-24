package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import models.User;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

   

    public WebElement fullNameInput() {
        return driver.findElement(By.xpath(".//input[@name='full_name']"));
    }


    public WebElement storeNameInput() {
        return driver.findElement(By.xpath(".//input[@name='store_name']"));
    }


    public WebElement emailInput() {
        return driver.findElement(By.xpath(".//input[@name='email']"));
    }


    public WebElement phoneInput() {
        return driver.findElement(By.xpath(".//input[@name='mobile_number']"));
    }


    public WebElement passwordInput() {
        return driver.findElement(By.xpath(".//input[@name='password']"));
    }


    public WebElement passwordConfirmInput() {
        return driver.findElement(By.xpath(".//input[@name='rpassword']"));
        
    }


    public WebElement regBusinessYes() {
        return driver.findElement(By.className("transform-checkbox-icon"));
}
    public WebElement signupButton() {
        return driver.findElement(By.id("register-submit-btn"));
    }

    public void open() {
        driver.navigate().to("https://merchant.kashier.io/en/signup/");
    }
    public void assertfullNameValidation() {
        var actualError = getErrorMessage("Full Name");
        Assertions.assertEquals("Full Name must be between 1 and 32 characters!", actualError);
    }

    public void assertstoreNameValidation() {
        var actualError = getErrorMessage("Store Name");
        Assertions.assertEquals("Store Name must be between 1 and 32 characters!", actualError);
    }

    public void assertEmailValidation() {
        var actualError = getErrorMessage("E-Mail");
        Assertions.assertEquals("E-Mail Address does not appear to be valid!", actualError);
    }

    public void assertphoneValidation() {
        var actualError = getErrorMessage("phone");
        Assertions.assertEquals("phone must be between 3 and 32 characters!", actualError);
    }

    public void assertPasswordValidation() {
        var actualError = getErrorMessage("Password");
        Assertions.assertEquals("Password must be between 4 and 20 characters!", actualError);
    }

    public void assertPasswordConfirmationMismatchValidation() {
        var actualError = getErrorMessage("Password Confirm");
        Assertions.assertEquals("Password confirmation does not match password!", actualError);
    }


    public String getErrorMessage(String inputLabel) {
        var xpathLocator = String.format("//label[text()='%s']//following-sibling::div/div", inputLabel);
        return driver.findElement(By.xpath(xpathLocator)).getText();
    }

    public void assertPlaceholder(String expectedText, WebElement element) {
        var actualPlaceHolder = getPlaceholder(element);
        Assertions.assertEquals(expectedText, actualPlaceHolder);
    }

    public String getPlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public void register(User user, Boolean useEnter) {
        if (!user.getfullName().isEmpty()) {
            fullNameInput().sendKeys(user.getfullName());
        }

        if (!user.getstoreName().isEmpty()) {
            storeNameInput().sendKeys(user.getstoreName());
        }

        if (!user.getemail().isEmpty()) {
            emailInput().sendKeys(user.getemail());
        }

        if (!user.getphone().isEmpty()) {
            phoneInput().sendKeys(user.getphone());
        }

        if (!user.getPassword().isEmpty()) {
            passwordInput().sendKeys(user.getPassword());
        }

        if (!user.getPasswordConfirm().isEmpty()) {
            passwordConfirmInput().sendKeys(user.getPasswordConfirm());
        }


        if (useEnter) {
        	signupButton().sendKeys(Keys.ENTER);
        } else {
        	signupButton().click();
        }
    }
    }
