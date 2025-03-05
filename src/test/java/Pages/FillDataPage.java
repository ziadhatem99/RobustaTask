package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillDataPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public FillDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By onesieItem = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Onesie')]");
    private By backpackItem = By.xpath("//div[@data-test='inventory-item-name' and contains(text(), 'Sauce Labs Fleece Jacket')]");
    private By successMessage = By.xpath("//h2[contains(text(),'Thank you for your order!')]");
    public FillDataPage addFirstName(String firstName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        element.sendKeys(firstName);
        return this;
    }
    public FillDataPage addLastName(String LastName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        element.sendKeys(LastName);
        return this;
    }
    public FillDataPage addPostalCode(String postalCode){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        element.sendKeys(postalCode);
        return this;
    }
    public FillDataPage clickContinue(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn));
        element.click();
        return this;
    }
    public FillDataPage clickFinish(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn));
        element.click();
        return this;
    }
    public boolean isOnesieItemPresent() {
        return !driver.findElements(onesieItem).isEmpty();
    }
    public boolean isBackpackItemPresent() {
        return !driver.findElements(backpackItem).isEmpty();
    }
    public boolean isSuccessMessageDisplayed(){
        return !driver.findElements(successMessage).isEmpty();
    }
}
