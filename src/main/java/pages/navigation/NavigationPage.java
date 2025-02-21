package pages.navigation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class NavigationPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Home-screen\"]//android.widget.ImageView[1]\n")
    private MobileElement homeDefaImg;

    @AndroidFindBy(xpath = "//*[@content-desc='Home']")
    private MobileElement home;

    @AndroidFindBy(xpath = "//*[@content-desc='Webview']")
    private MobileElement webview;

    @AndroidFindBy(xpath = "//*[@content-desc='Login']")
    private MobileElement login;

    @AndroidFindBy(xpath = "//*[@content-desc='Forms']")
    private MobileElement forms;

    @AndroidFindBy(xpath = "//*[@content-desc='Swipe']")
    private MobileElement swipe;

    @AndroidFindBy(xpath = "//*[@content-desc='Drag']")
    private MobileElement drag;


    public NavigationPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void verifyHomeDefaImgDisplay(){
        waitForVisibility(homeDefaImg);
    }

    public void clickNavHome(){
        waitForVisibility(home);
        click(home);
    }

    public void clickNavLogin(){
        waitForVisibility(login);
        click(login);
    }

    public void clickNavForms(){
        waitForVisibility(forms);
        click(forms);
    }

}
