package com.agileprocrm.pages;

import com.agileprocrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@name='USER_LOGIN']")
    public WebElement usernameInput;

    @FindBy (xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordInput;

    @FindBy (xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    @FindBy (xpath = "//div[@class='errortext']")
    public WebElement errorMessage;

}
