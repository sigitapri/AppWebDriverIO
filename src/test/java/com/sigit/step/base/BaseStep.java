package com.sigit.step.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import static com.sigit.hooks.Hooks.driver;

public class BaseStep {


    public static SoftAssert softAssert = new SoftAssert();
//
//    public static SoftAssertions softAssertJ = new SoftAssertions();
    public static byte[] getByteScreenshot() throws IOException
    {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }


}
