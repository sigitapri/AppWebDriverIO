package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class LoginWdioPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@content-desc='input-email']")
    private MobileElement fieldEmail;

    @AndroidFindBy(xpath = "//*[@content-desc='input-password']")
    private MobileElement fieldPassword;

    @AndroidFindBy(xpath = "//*[@content-desc='button-LOGIN']")
    private MobileElement buttonLogin;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement messageSuccess;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement buttonOkPopUP;

    @AndroidFindBy(xpath = "//*[@text=\"Please enter a valid email address\"]")
    private MobileElement messageInvalidEmail;

    @AndroidFindBy(xpath = "//*[@text=\"Please enter at least 8 characters\"]")
    private MobileElement messageInvalidPass;


    public LoginWdioPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void inputEmail(String email){
        waitForVisibility(fieldEmail);
        fieldEmail.sendKeys(email);
    }

    public void inputPassword(String pass){
        waitForVisibility(fieldPassword);
        fieldPassword.sendKeys(pass);
    }

    public void clickButtonLogin(){
        waitForVisibility(buttonLogin);
        click(buttonLogin);
    }

    public String verifySuccessLoginDisplay(){
        waitForVisibility(messageSuccess);
        return messageSuccess.getText();
    }

    public String verifyMessageInvalidEmailDisplay(){
        waitForVisibility(messageInvalidEmail);
        return messageInvalidEmail.getText();
    }

    public String verifyMessageInvalidPassDisplay(){
        waitForVisibility(messageInvalidPass);
        return messageInvalidPass.getText();
    }

    public void clickButtonOkSuccess(){
        waitForVisibility(buttonOkPopUP);
        click(buttonOkPopUP);
    }

}
