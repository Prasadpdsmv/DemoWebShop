package com.hooks;

import com.baseUtility.PLaywrightUtility;
import com.baseUtility.ScreenShotUtility;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;

public class Hooks {

    /*public void IntializeTheBrowser(){

        System.out.println("this is before suite");
        PLaywrightUtility.setUpPage();
    }*/



    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        String screenshotName =
                scenario.getName() + "_"
                        + System.currentTimeMillis();

        scenario.attach(
                ScreenShotUtility.captureScreenshot(),
                "image/png",
                screenshotName
        );
    }


}
