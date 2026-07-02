package com.pages;

import com.baseUtility.PLaywrightUtility;
import com.baseUtility.PlaywrightManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    Page page;

    private static String TopMenu=".top-menu";
    private String APEARL_SHOES_MENU="Apparel & Shoes";
    private String MENU_LIST="top-menu";

    public HomePage() {
        this.page= PlaywrightManager.page();
    }

    private Locator  menuItems(String menu){
        return page.locator(TopMenu).getByRole(AriaRole.LINK,new Locator.GetByRoleOptions().setName(menu));
    }

    public void clickOnMenu(String menu){
        page.waitForLoadState();
        menuItems(menu).click();
    }
    public void navigateToHomePage(){
        System.out.println("this is a home page and requests and responses ");
        //page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.url()));
        //page.onResponse(response -> System.out.println("<<" + response.status() + " " + response.url()));
        page.navigate("https://demowebshop.tricentis.com/");
    }
    public void navigateToAppearlAndShoes(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(APEARL_SHOES_MENU))
                .click();

    }
}
