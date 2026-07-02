package com.pages;

import com.baseUtility.PlaywrightManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class DigitalDownloadsPage {
    private final Page page;

    private String PAGE_TITLE = "Digital downloads";
    private String SORTING_PRODUCTS = "select#products-orderby";
    private String DISPLAY_PAGES = "select#products-pagesize";
    private String PRODUCT_ITEMS = ".product-item";
    private String NOTIFICATION_CONFIRMATION = "#bar-notification";
    private String OUT_OF_STOCK = "Out of stock";
    private String ADDED_TO_CART = "The product has been added to your ";

    public DigitalDownloadsPage() {
        this.page = PlaywrightManager.page();
    }

    public void verifyPageHeader() {
        System.out.println("Navigated to Digital Downloads page");

        PlaywrightAssertions.assertThat(page.getByRole(AriaRole.HEADING, 
            new Page.GetByRoleOptions().setName(PAGE_TITLE))).isVisible();
    }


    public void networkLogs(){
        page.onRequest(
                request -> {
                    request.url();
                    request.method();
                    request.headers();
                }
        );

    }


}