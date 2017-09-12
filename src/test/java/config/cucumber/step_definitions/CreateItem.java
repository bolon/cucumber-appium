package config.cucumber.step_definitions;

import commons.AppiumSetup;
import commons.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateItem extends AppiumSetup {
    @Then("^I will go to \"([^\"]*)\" page$")
    public void i_will_go_to_page(String pageName) throws Throwable {
        String elementId;

        switch (pageName) {
            case "Sign In": {
                elementId = pkgName + "goToSignIn";
                webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(elementId))).click();
            }
            break;
        }
    }

    @When("^I am in login page$")
    public void i_am_in_login_page() throws Throwable {
        String elementId = pkgName + "signInButton";
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("^I will enter valid credential$")
    public void i_will_enter_valid_credential() throws Throwable {
        String txtFieldEmailId = pkgName + "email";
        String txtFieldPwdId = pkgName + "password";

        WebElement usernameField = appiumDriver.findElementById(txtFieldEmailId);
        WebElement pwdField = appiumDriver.findElementById(txtFieldPwdId);

        usernameField.sendKeys(TestUtils.getProperty("valid_mail"));
        pwdField.sendKeys(TestUtils.getProperty("valid_pwd"));
    }

    @Then("^I will be on main page$")
    public void i_will_be_on_main_page() throws Throwable {
        String crudBtnId = pkgName + "crud_btn";
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(crudBtnId)));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("^I will be on item creation page$")
    public void i_will_be_on_item_creation_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I will see menus$")
    public void i_will_see_menus() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    /*
    Then I will be on main page
    When I click "CRUD" button
    Then I will see menus
    When I click "Create Item" menu
    Then I will be on item creation page
     */
}
