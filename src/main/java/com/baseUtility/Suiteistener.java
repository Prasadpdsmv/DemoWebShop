package com.baseUtility;

import com.microsoft.playwright.Tracing;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.nio.file.Paths;

public class Suiteistener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("this is before suite");
       // PLaywrightUtility.setUpPage();
        // we created PlaywrightManager to support parallel testing
        PlaywrightManager.initialize();
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("After Suite Execution");

        try {

            PlaywrightManager.browserContext().tracing().stop(
                    new Tracing.StopOptions()
                            .setPath(
                                    Paths.get(
                                            "test-results/traces/"
                                                    + suite.getName()
                                                    + ".zip")));

        } catch (Exception e) {
            e.printStackTrace();
        }

       /* if (PLaywrightUtility.page != null) {
            PLaywrightUtility.page.close();
        }

        if (PLaywrightUtility.browserContext != null) {
            PLaywrightUtility.browserContext.close();
        }

        if (PLaywrightUtility.browser != null) {
            PLaywrightUtility.browser.close();
        }

        if (PLaywrightUtility.playWright != null) {
            PLaywrightUtility.playWright.close();
        }*/

        // replced with PlaywrightManager manager class

        PlaywrightManager.close();
    }
}
