package signup;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import factories.UserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v95.log.Log;
import pages.AccountSuccessPage;
import pages.RegistrationPage;

import java.util.*;
import java.util.function.Consumer;


public class SignupTests {
    private WebDriver driver;

    private List<JavascriptException> jsExceptionsList;
    private RegistrationPage registrationPage;
    private AccountSuccessPage accountSuccessPage;

    @BeforeAll
    public static void setUpClass() {

       WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
	@BeforeEach
    public void setUp() {
    	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
      	 WebDriver driver = new ChromeDriver();
    	 driver.get("https://merchant.kashier.io/en/signup");
    	 
        registrationPage = new RegistrationPage(driver);
        accountSuccessPage = new AccountSuccessPage(driver);

        DevTools devTools = ((HasDevTools)driver).getDevTools();
        devTools.createSession();

        // configure JS exceptions logging
        jsExceptionsList = new ArrayList<>();
        Consumer<JavascriptException> addEntry = jsExceptionsList::add;
        devTools.getDomains().events().addJavascriptExceptionListener(addEntry);

        // configure console messages logging
        List<String> consoleMessages = new ArrayList<>();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    consoleMessages.add("log: " + logEntry.getText() + "level: " + logEntry.getLevel());
                });
    }

    // happy path
    @Test
    public void userCreatedSuccessfully_when_allRequiredFieldsField_and_clickContinueButton() {
       var user = UserFactory.createDefault();
       user.setphone("01010810066");

        registrationPage.open();
        registrationPage.register(user, false);
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        accountSuccessPage.assertAccountCreatedSuccessfully();
        }

}