package com.agileprocrm.step_definitions;

import com.agileprocrm.pages.DashboardPage;
import com.agileprocrm.pages.LoginPage;
import com.agileprocrm.utilities.ConfigurationReader;
import com.agileprocrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    Driver driver;

    @Given("user is already logged in the app")
    public void user_is_already_logged_in_the_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
        loginPage.usernameInput.sendKeys("hr1@cybertekschool.com");
        loginPage.passwordInput.sendKeys("UserUser");
        loginPage.loginButton.click();

    }
    @When("user clicks the profile name")
    public void user_clicks_the_profile_name() {
        dashboardPage.profileName.click();
    }

    @When("user clicks logout button")
    public void user_clicks_logout_button() {
        dashboardPage.logOutButton.click();
    }
    @Then("user lands on login page")
    public void user_lands_on_login_page() {
    String expectedTitle = "Authorization";
    String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("user clicks back button")
    public void userClicksBackButton()  {
        Driver.getDriver().navigate().back();
    }

    @When("user closes the tab")
    public void userClosesTheTabS() {
        Driver.closeDriver();
    }

    @Then("user navigates back to login page")
    public void userNavigatesBackToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }
}
