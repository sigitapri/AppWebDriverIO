package com.sigit.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.DeviceApi;
import utils.PropertyManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {
    public static AndroidDriver<AndroidElement> driver;



    private DeviceApi deviceApi;


    private final DesiredCapabilities caps = new DesiredCapabilities();

    static Properties props;

    static {
        try {
            props = new PropertyManager().getPropsDemo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String STF_SERVICE_URL = props.getProperty("device-farmer-serviceurl");
    private static final String ACCESS_TOKEN = props.getProperty("device-farmer-accesstoken");

    private TakesScreenshot webDriver;
    private Scenario scenario;

    public Hooks() throws IOException {
    }


    @Before
    public void setupDeviceCapabilities() throws IOException, URISyntaxException {

        caps.setCapability("deviceName", props.getProperty("data.deviceName"));
        caps.setCapability("platformName", props.getProperty("data.platformName"));
        caps.setCapability("platformVersion", props.getProperty("data.platformVersion"));
        caps.setCapability("udid",props.getProperty("data.udid"));
        caps.setCapability("app", new File(System.getProperty("user.dir")
                + "/src/test/resources/apk/apk-demo/android.wdio.native.app.v1.0.8.apk").getAbsolutePath());
        caps.setCapability("appPackage", props.getProperty("data.appPackage"));
        caps.setCapability("appActivity", props.getProperty("data.appActivity"));
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", false);

//        STFService stfService = new STFService(STF_SERVICE_URL, ACCESS_TOKEN);
//        deviceApi = new DeviceApi(stfService);
//        deviceApi.connectDevice(props.getProperty("data.udid"));

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }


    @After(order = 0)
    public void stopAndroidDriver() throws InterruptedException{
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

}
