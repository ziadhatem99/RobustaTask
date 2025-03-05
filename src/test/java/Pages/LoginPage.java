package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage enterUserName(String userName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        element.sendKeys(userName);
        return this;
    }
    public LoginPage enterPassword(String password){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.sendKeys(password);
        return this;
    }
    public LoginPage clickLogin(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        element.click();
        return this;
    }
}
