package com.guidersoft.stepdefs;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.pageobjects.Menuobjeckt;
import com.guidersoft.webdriver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps {
    @Given("user on homepage")
    public void userOnHomepage() {
        TestConfig config=TestConfigReader.instance().getConfig();
        Driver.getDriver().get(config.getApplication().getUrl());
    }

    @When("^user click (LOGIN|SIGNUP|HOME|CART|PRODUCTS|CONTACTUS) on menu$")
    public void userClickOnMenu(String menutxt) {
        Menuobjeckt menu = new Menuobjeckt();
        switch (menutxt) {
            case "LOGIN":
            case "SIGNUP":
                menu.signuplogin.click();
                break;
            case "HOME":
                menu.home.click();
                break;
            case "CART":
                menu.cart.click();
                break;
            case "PRODUCTS":
                menu.products.click();
                break;
            case "CONTACTUS":
                menu.ContactUs.click();
                break;
        }




      /*  String locatorStr="//ul[@class='nav navbar-nav']//a[contains(.,'%s')]";
        By locator=null;
        switch (menutxt){
            case "LOGIN":
            case "SIGNUP":
                locatorStr=String.format(locatorStr, "Signup/Login");
                locator=By.xpath(locatorStr);
                break;
            case "HOME":
                break;

        }*/
    }

    @And("user fills the login form as {string}")
    public void userFillsTheLoginFormAs(String arg0) {
    }

    @And("user clicks to button {string}")
    public void userClicksToButton(String arg0) {
    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
    }


}
