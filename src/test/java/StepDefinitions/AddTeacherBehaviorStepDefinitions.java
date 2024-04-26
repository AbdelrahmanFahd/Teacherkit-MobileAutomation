package StepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AddTeacherBehaviorStepDefinitions {
    AndroidDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() throws MalformedURLException {
        // Set DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("automationName", "UiAutomator2");

        // Set Capability for Build in App
        caps.setCapability("appPackage", "com.itworx.winjigoteacher");
        caps.setCapability("appActivity", "com.itworx.winjigoteachermoe.presention.ui.activities.SplashActivity");
        // URL Appium Server
        URL url = new URL("http://localhost:4723/wd/hub");

        // definition Android Driver
        driver = new AndroidDriver(url, caps);
        loginPage = new LoginPage(driver);
    }

    @Given("^User Enter \"(.*)\" and \"(.*)\"$")
    public void userEnterEmailAndPassword(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getStarted));

        loginPage.clickGetStarted();
        loginPage.enterCredentials(email, password);
    }

}
