package com.sigit.step.login;

import com.sigit.hooks.Hooks;
import com.sigit.step.base.BaseStep;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.login.LoginWdioPage;
import pages.navigation.NavigationPage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class LoginWdioStep extends BaseStep {

    private final AndroidDriver<AndroidElement> driver;

    private Properties props = new PropertyManager().getPropsDemo();

    public LoginWdioStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Given("The user opens app web driver io")
    public void theUserOpensAppWebDriverIo() {
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.verifyHomeDefaImgDisplay();
    }

    @When("User click login navigation")
    public void userClickLoginNavigation() {
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavLogin();
    }

    @And("User input email {string}")
    public void userInputEmail(String email) {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        loginWdioPage.inputEmail(email);
    }

    @And("User input invalid email format {string}")
    public void userInputInvalidEmailFormat(String invMail) {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        loginWdioPage.inputEmail(invMail);
    }

    @And("User input password {string}")
    public void userInputPassword(String pass) {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        loginWdioPage.inputPassword(pass);
    }

    @And("User input password format {string}")
    public void userInputPasswordFormat(String invPass) {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        loginWdioPage.inputPassword(invPass);
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        loginWdioPage.clickButtonLogin();
    }


    @Then("Verify login success")
    public void verifyLoginSuccess() {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        loginWdioPage.verifySuccessLoginDisplay();
        Assert.assertEquals(loginWdioPage.verifySuccessLoginDisplay(), props.getProperty("data.login.success"));
        String message = loginWdioPage.verifySuccessLoginDisplay();
        System.out.println("message login is : " + message);
        loginWdioPage.clickButtonOkSuccess();
    }


    @Then("Verify failed login message invalid email format shown")
    public void verifyFailedLoginMessageInvalidEmailFormatShown() {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        Assert.assertEquals(loginWdioPage.verifyMessageInvalidEmailDisplay(), props.getProperty("data.login.invEmail"));
        String mesInvEmail = loginWdioPage.verifyMessageInvalidEmailDisplay();
        System.out.println("invalid message email is : " + mesInvEmail);
    }

    @Then("Verify failed login message invalid password format shown")
    public void verifyFailedLoginMessageInvalidPasswordFormatShown() {
        LoginWdioPage loginWdioPage = new LoginWdioPage(driver);
        Assert.assertEquals(loginWdioPage.verifyMessageInvalidPassDisplay(), props.getProperty("data.login.invPass"));
        String mesInvPass = loginWdioPage.verifyMessageInvalidPassDisplay();
        System.out.println("invalid message password is : " + mesInvPass);
    }

}
