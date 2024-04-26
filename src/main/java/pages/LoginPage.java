package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = AppiumBy.id("emailView");
    By password = AppiumBy.id("passwordView");
    By loginButton = AppiumBy.id("buttonLogin");
    public By getStarted = AppiumBy.className("android.widget.Button");

    public void enterCredentials(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.email));
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();

    }

    public void clickGetStarted() {
        driver.findElement(getStarted).click();
    }
}
