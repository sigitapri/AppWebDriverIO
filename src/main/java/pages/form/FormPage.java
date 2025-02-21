package pages.form;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class FormPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@content-desc='text-input']")
    private MobileElement fieldInput;

    @AndroidFindBy(xpath = "//*[@content-desc='input-text-result']")
    private MobileElement fieldInputResult;

    @AndroidFindBy(xpath = "//*[@content-desc='switch']")
    private MobileElement buttonSwitch;

    @AndroidFindBy(xpath = "//*[@content-desc='switch-text']")
    private MobileElement switchText;

    @AndroidFindBy(xpath = "//*[@content-desc='Dropdown']")
    private MobileElement dropDown;

    @AndroidFindBy(xpath = "//*[@text=\"webdriver.io is awesome\"]")
    private MobileElement dropDown_text1;

    @AndroidFindBy(xpath = "//*[@text=\"Appium is awesome\"]")
    private MobileElement dropDown_text2;

    @AndroidFindBy(xpath = "//*[@text=\"This app is awesome\"]")
    private MobileElement dropDown_text3;

    @AndroidFindBy(xpath = "//*[@content-desc='button-Active']")
    private MobileElement buttonActive;

    @AndroidFindBy(xpath = "//*[@content-desc='button-Inactive']")
    private MobileElement buttonInactive;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement textPopUp;

    @AndroidFindBy(id = "android:id/button3")
    private MobileElement buttonAskMeLatter;

    public FormPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void inputFieldInput(String input){
        waitForVisibility(fieldInput);
        fieldInput.sendKeys(input);
    }

    public String getLableYouHaveType(){
        waitForVisibility(fieldInputResult);
        return fieldInputResult.getText();
    }

    public void clickButtonSwitch(){
        waitForVisibility(buttonSwitch);
        click(buttonSwitch);
    }

    public String getSwitchDesc(){
        waitForVisibility(switchText);
        return switchText.getText();
    }

    public void selectDropDown1(){
        waitForVisibility(dropDown);
        click(dropDown);
        click(dropDown_text1);
    }

    public void selectDropDown2(){
        waitForVisibility(dropDown);
        click(dropDown);
        click(dropDown_text2);
    }

    public void selectDropDown3(){
        waitForVisibility(dropDown);
        click(dropDown);
        click(dropDown_text3);
    }

    public void clickButtonActive(){
        waitForVisibility(buttonActive);
        click(buttonActive);
    }

    public void clickButtonInactive(){
        waitForVisibility(buttonInactive);
        click(buttonInactive);
    }

    public String getPopUpText(){
        waitForVisibility(textPopUp);
        return textPopUp.getText();
    }

    public void clickButtonAskMeLater(){
        waitForVisibility(buttonAskMeLatter);
        click(buttonAskMeLatter);
    }


}
