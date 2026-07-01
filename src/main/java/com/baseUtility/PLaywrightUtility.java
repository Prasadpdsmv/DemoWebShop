package com.baseUtility;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;
import java.util.Arrays;

public class PLaywrightUtility {
    public static Playwright playWright;

    public static Browser browser;
    public static BrowserContext browserContext;
    public static Page page;

    //@BeforeSuite
    public static void setUpPage(){
        System.out.println("this is intialisation from before suite at base clas");
        playWright=Playwright.create();
        browser=playWright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        browserContext=browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(null)
                        .setRecordVideoDir(
                                Paths.get("test-results/videos"))
        );
        page=browserContext.newPage();
        browserContext.tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );
    }

}
