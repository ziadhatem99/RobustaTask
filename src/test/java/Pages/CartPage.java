package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By checkOutBtn = By.id("checkout");
    private By cartIcon = By.xpath("//span[@class='shopping_cart_badge']");

    public CartPage clickCheckOut(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn));
        element.click();
        return this;
    }
    public String getCartItemCount() {
        WebElement badgeElement = driver.findElement(cartIcon);
        return badgeElement.getText();
    }
    public CartPage verifyCartItemCount(String expectedItemCount) {
        String itemCount =getCartItemCount();
        Assert.assertEquals(itemCount, expectedItemCount, "The cart item count is not as expected!");
        return this;
    }
}
