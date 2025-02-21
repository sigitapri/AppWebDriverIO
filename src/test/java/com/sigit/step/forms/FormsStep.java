package com.sigit.step.forms;

import com.sigit.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.form.FormPage;
import pages.navigation.NavigationPage;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class FormsStep {

    private final AndroidDriver<AndroidElement> driver;

    private Properties props = new PropertyManager().getPropsDemo();

    public FormsStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Given("User click navigation forms")
    public void userClickNavigationForms() {
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavForms();
    }

    @When("User input field forms scnario1")
    public void userInputFieldForms() {
        FormPage formPage = new FormPage(driver);
        formPage.inputFieldInput(props.getProperty("data.forms.inputField1"));
    }


    @And("User verify that you have typed")
    public void userVerifyThatYouHaveTyped() {
        FormPage formPage = new FormPage(driver);
        Assert.assertEquals(formPage.getLableYouHaveType(), props.getProperty("data.forms.inputField1"));
        String field1 = formPage.getLableYouHaveType();
        System.out.println("Lable have you type is : " + field1);
    }

    @And("User click button switch to ON")
    public void userClickButtonSwitchToON() {
        FormPage formPage = new FormPage(driver);
        formPage.clickButtonSwitch();
    }


    @And("Verify switch text desc has ON")
    public void verifySwitchTextDescHasON() {
        FormPage formPage = new FormPage(driver);
        Assert.assertEquals(formPage.getSwitchDesc(), props.getProperty("data.forms.switchDescON"));
    }

    @And("User select dropdown webdriver.io is awesome")
    public void userSelectDropdownWebdriverIoIsAwesome() {
        FormPage formPage = new FormPage(driver);
        formPage.selectDropDown1();
    }

    @And("User click button active")
    public void userClickButtonActive() {
        FormPage formPage = new FormPage(driver);
        formPage.clickButtonActive();
    }

    @Then("Verify pop up this button active")
    public void verifyPopUpThisButtonActive() {
        FormPage formPage = new FormPage(driver);
        Assert.assertEquals(props.getProperty("data.forms.popUpThisButtonActive"), formPage.getPopUpText());
        String PopUpMessage = formPage.getPopUpText();
        System.out.println("Pop up message is : " + PopUpMessage);
    }

    @When("User input field forms scnario2")
    public void userInputFieldFormsScnario() {
        FormPage formPage = new FormPage(driver);
        formPage.inputFieldInput(props.getProperty("data.forms.inputField2"));
    }

    @And("User click button switch to OFF")
    public void userClickButtonSwitchToOFF() {
        FormPage formPage = new FormPage(driver);
        formPage.clickButtonSwitch();
        formPage.clickButtonSwitch();
    }

    @And("Verify switch text desc has OFF")
    public void verifySwitchTextDescHasOFF() {
        FormPage formPage = new FormPage(driver);
        Assert.assertEquals(formPage.getSwitchDesc(), props.getProperty("data.forms.switchDescOFF"));
    }

    @And("User select dropdown This app is awesome")
    public void userSelectDropdownThisAppIsAwesome() {
        FormPage formPage = new FormPage(driver);
        formPage.selectDropDown3();
    }

    @And("User click button inactive")
    public void userClickButtonInactive() {
        FormPage formPage = new FormPage(driver);
        formPage.clickButtonInactive();
    }

    @And("User verify that you have typed scnario2")
    public void userVerifyThatYouHaveTypedScnario() {
        FormPage formPage = new FormPage(driver);
        Assert.assertEquals(props.getProperty("data.forms.inputField2"), formPage.getLableYouHaveType());
    }

    @When("User input field forms scnario3")
    public void userInputFieldFormsScnario3() {
        FormPage formPage = new FormPage(driver);
        formPage.inputFieldInput(props.getProperty("data.forms.inputField3"));
    }

    @And("User verify that you have typed scnario3")
    public void userVerifyThatYouHaveTypedScnario3() {
        FormPage formPage = new FormPage(driver);
        Assert.assertEquals(formPage.getLableYouHaveType(), props.getProperty("data.forms.inputField3"));
        String field1 = formPage.getLableYouHaveType();
        System.out.println("Lable have you type is : " + field1);
    }

    @And("User select dropdown Appium is awesome")
    public void userSelectDropdownAppiumIsAwesome() {
        FormPage formPage = new FormPage(driver);
        formPage.selectDropDown3();
    }

    @Then("Verify pop up this button active did not show")
    public void verifyPopUpThisButtonActiveDidNotShow() {
    }
}
