package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By addJacketToCart = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By openOnesie = By.id("item_2_title_link");
    private By addOnesieToCart = By.id("add-to-cart");
    private By cartButton = By.id("shopping_cart_container");
    private By cartIconCount = By.id("//span[@class='shopping_cart_badge']");

    public HomePage addJacket(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addJacketToCart));
        element.click();
        return this;
    }
    public HomePage clickOpenOnesiePage(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(openOnesie));
        element.click();
        return this;
    }
    public HomePage clickAddOnesieToCart(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addOnesieToCart));
        element.click();
        return this;
    }
    public HomePage clickCartBtn(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        element.click();
        return this;
    }
}
