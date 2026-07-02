package com.baseUtility;

import com.microsoft.playwright.*;

public class PlaywrightManager {

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initialize() {

        System.out.println("playwright intialization started");

        System.out.println("threads and the number :: "+Thread.currentThread().getName());

        playwright.set(Playwright.create());

        browser.set(
                playwright.get()
                        .chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false))
        );

        context.set(browser.get().newContext());

        page.set(context.get().newPage());

        context.get().tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true));

        System.out.println("playwright initialization completed");
    }

    public static Page page() {
        return page.get();
    }

    public static BrowserContext browserContext(){return context.get();}

    public static void close() {

        page.get().close();
        context.get().close();
        browser.get().close();
        playwright.get().close();
    }
}