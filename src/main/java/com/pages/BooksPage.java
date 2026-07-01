package com.pages;

import com.baseUtility.PLaywrightUtility;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class BooksPage extends PLaywrightUtility {
    //Page page;

    public void selectBook(String bookName){
        /*Locator locator=page.locator("a")
                .filter(new Locator.FilterOptions().setHasText(bookName));*/

        Locator locator=page.locator("div.item-box")
                        .filter(new Locator.FilterOptions().setHasText(bookName));

        System.out.println("the locator value: "+ locator);

       // System.out.println(locator.getAttribute("*"));
        System.out.println(locator.textContent());

        locator.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Add to cart")).click();

    }

}