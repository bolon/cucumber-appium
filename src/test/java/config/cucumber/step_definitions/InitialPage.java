package config.cucumber.step_definitions;

import commons.AppiumSetup;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class InitialPage {
    String pkgName;
    WebDriverWait waitDriver;
    AppiumDriver driver;

    /**
     * Teardown app after a scenario finished executed
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Note : not sure put this in a scenario or in an @Before annotated method.
     *
     * @throws Throwable
     */
    @Given("^I am in Moka App initial page$")
    public void i_am_in_Moka_App_initial_page() throws Throwable {
        try {
            AppiumSetup.prepareDriver(AppiumSetup.DRIVER_PREF.ANDROID);
            pkgName = AppiumSetup.pkgName;
            waitDriver = AppiumSetup.webDriverWait;
            driver = AppiumSetup.appiumDriver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Then("^I will see login button$")
    public void i_will_see_login_button() throws Throwable {
        String btnLoginId = pkgName + "goToSignIn";
        WebElement btnLogin = waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(btnLoginId)));

        Assert.assertTrue(btnLogin.isDisplayed());
    }

    @Then("^I will see register button$")
    public void i_will_see_register_button() throws Throwable {
        String btnRegisterId = pkgName + "goToCreateAccount";
        WebElement btnRegister = waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(btnRegisterId)));

        Assert.assertTrue(btnRegister.isDisplayed());
    }

    @Then("^I will be able to click login button$")
    public void i_will_be_able_to_click_login_button() throws Throwable {
        String btnLoginId = pkgName + "goToSignIn";
        WebElement btnLogin = waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(btnLoginId)));

        Assert.assertTrue(btnLogin.isEnabled());
    }

    @Then("^I will be able to click register button$")
    public void i_will_be_able_to_click_register_button() throws Throwable {
        String btnRegisterId = pkgName + "goToCreateAccount";
        WebElement btnRegister = waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(btnRegisterId)));

        Assert.assertTrue(btnRegister.isEnabled());
    }

}
