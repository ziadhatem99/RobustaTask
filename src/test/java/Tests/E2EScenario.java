package Tests;

import Base.Api;
import Base.Assets;
import Pages.CartPage;
import Pages.FillDataPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2EScenario{
    protected WebDriver driver;
    Api api;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    @Description("End to End test to create order from scratch")
    public void makeSuccessfulOrder(){
        FillDataPage fillDataPage = new FillDataPage(driver);
        api = new Api();
        api.getData();
        String firstName = api.getFirstName();
        String lastName = api.getLastName();
        String zipCode = api.getZipCode();
        driver.get(Assets.webSiteUrl);


        new LoginPage(driver)
                .enterUserName(Assets.userName)
                .enterPassword(Assets.password)
                .clickLogin();

        new HomePage(driver)
                .addJacket()
                .clickOpenOnesiePage()
                .clickAddOnesieToCart()
                .clickCartBtn();

        new CartPage(driver)
                .verifyCartItemCount("2")
                .clickCheckOut();

        new FillDataPage(driver)
                .addFirstName(firstName)
                .addLastName(lastName)
                .addPostalCode(zipCode)
                .clickContinue();

        Assert.assertTrue(fillDataPage.isOnesieItemPresent(), "Sauce Labs Onesie is not present!");
        Assert.assertTrue(fillDataPage.isBackpackItemPresent(), "SSauce Labs Fleece Jacket is not present!");

                new FillDataPage(driver)
                        .clickFinish();
        Assert.assertTrue(fillDataPage.isSuccessMessageDisplayed() , "Order failed!");
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
