package config.cucumber.step_definitions;

import commons.AppiumSetup;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class BaseAppPage extends AppiumSetup {
    /**
     * Teardown app after a scenario finished executed
     * Note : Just put once since its called from every
     */
    @After
    public void tearDown() {
        appiumDriver.quit();
    }

    /**
     * Note : not sure put this in a scenario or in an @Before annotated method.
     *
     * @throws Throwable
     */
    @Given("^I am in Moka App initial page$")
    public void i_am_in_Moka_App_initial_page() throws Throwable {
        try {
            prepareDriver(AppiumSetup.DRIVER_PREF.ANDROID);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Then("^I will see login button$")
    public void i_will_see_login_button() throws Throwable {
        String btnLoginId = pkgName + "goToSignIn";
        WebElement btnLogin = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(btnLoginId)));

        Assert.assertTrue(btnLogin.isDisplayed());
    }

    @Then("^I will see register button$")
    public void i_will_see_register_button() throws Throwable {
        String btnRegisterId = pkgName + "goToCreateAccount";
        WebElement btnRegister = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(btnRegisterId)));

        Assert.assertTrue(btnRegister.isDisplayed());
    }

    @Then("^I will be able to click login button$")
    public void i_will_be_able_to_click_login_button() throws Throwable {
        String btnLoginId = pkgName + "goToSignIn";
        WebElement btnLogin = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(btnLoginId)));

        Assert.assertTrue(btnLogin.isEnabled());
    }

    @Then("^I will be able to click register button$")
    public void i_will_be_able_to_click_register_button() throws Throwable {
        String btnRegisterId = pkgName + "goToCreateAccount";
        WebElement btnRegister = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(btnRegisterId)));

        Assert.assertTrue(btnRegister.isEnabled());
    }

    @When("^I click \"([^\"]*)\" button$")
    public void i_click_button(String btnName) throws Throwable {
        clickElement(btnName);
    }

    @When("^I click \"([^\"]*)\" menu$")
    public void i_click_menu(String menuName) throws Throwable {
        clickElement(menuName);
    }


    void clickElement(String elementName) {
        String elementId = pkgName;

        switch (elementName) {
            case "Sign In": {
                elementId = elementId.concat("signInButton");
                break;
            }
            case "CRUD": {
                elementId = elementId.concat("crud_btn");
                break;
            }
            case "Create Item": {
                elementId = elementId.concat("menu_create_item");
                break;
            }
            case "Continue": {
                elementId = elementId.concat("outlet_continue");
            }
        }

        if (!elementId.equals(pkgName))
            appiumDriver.findElementById(elementId).click();
        else
            throw new NullPointerException("No Element ID supplied");
    }
}
