package com.agileprocrm.step_definitions;

import com.agileprocrm.pages.LoginPage;
import com.agileprocrm.utilities.ConfigurationReader;
import com.agileprocrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }
    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.usernameInput.sendKeys(username);
    }
    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.passwordInput.sendKeys(password);
    }
    @Then("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();

    }


    @When("user enters invalid username {string}")
    public void userEntersInvalidUsername(String invalidUsername) {
        loginPage.usernameInput.sendKeys(invalidUsername);
    }

    @When("user enters invalid password {string}")
    public void userEntersInvalidPassword(String invalidPassword) {
        loginPage.passwordInput.sendKeys(invalidPassword);
    }

    @When("user repeats entering invalid {string} and {string} credentials five times")
    public void userRepeatsEnteringInvalidAndCredentialsFiveTimes(String username, String password) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            loginPage.usernameInput.sendKeys(username);
            loginPage.passwordInput.sendKeys(password);
            loginPage.loginButton.click();
            Thread.sleep(1500);

        }
    }

    @Then("user gets {string}")
    public void userGets(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
