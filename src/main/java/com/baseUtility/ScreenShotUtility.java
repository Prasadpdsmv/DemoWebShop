package com.baseUtility;

public class ScreenShotUtility extends PLaywrightUtility {
    public static byte[] captureScreenshot() {

       /* return ((TakesScreenshot)
                driver)
                .getScreenshotAs(OutputType.BYTES);*/
        byte[] buffer = PlaywrightManager.page().screenshot();
        return buffer;
    }
}
