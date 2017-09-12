package config.cucumber.step_definitions;

import commons.AppiumSetup;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ChooseOutletPage extends AppiumSetup {
    @Then("^I will be on choosing outlet page$")
    public void i_will_be_on_choosing_outlet_page() throws Throwable {
        String elementId = pkgName + "business_image";
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("^I will choose outlet on position number (\\d+)$")
    public void i_will_choose_outlet_on_position_number(int pos) throws Throwable {
        String spinnerExpandId = pkgName + "outlet_triangle";
        appiumDriver.findElementById(spinnerExpandId).click();

        List<WebElement> spinnerChildren = appiumDriver.findElements(By.xpath("//android.widget.RelativeLayout"));

        spinnerChildren.get(pos).click();
    }
}
