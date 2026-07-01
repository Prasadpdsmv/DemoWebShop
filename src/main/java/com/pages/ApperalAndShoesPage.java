package com.pages;

import com.baseUtility.PLaywrightUtility;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ApperalAndShoesPage extends PLaywrightUtility {
    //Page page;
    private String PAGE_TITLE="Apparel & Shoes";
    private String SOTRING_PRODUCTS=".products-orderby";
    private String DISPLAY_PAGES=".products-pagesize";
    private String PRODUCT_ITEMS=".product-item";
    private String NOTIFICATION_CONFIRMATION=".bar-notification";
    private String OutOfStock="Out of stock";
    private String AddedToCart="The product has been added to your ";


    public void clickOnApperalAndShoes(){


        System.out.println("this is appearls and shoes page");
        page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.url()));
        page.onResponse(response -> System.out.println("<<" + response.status() + " " + response.url()));
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(PAGE_TITLE))
                .isVisible();

        page.onRequestFailed(request -> {
            System.out.println("this execute for any failed requests:"+ request.response());
        });
    }
    public Locator sortingItems(String option){
     return  page.locator(SOTRING_PRODUCTS).getByRole(AriaRole.OPTION, new Locator.GetByRoleOptions().setName(option));
    }
    public void selectSortingOrder(String option){
        sortingItems(option).click();
    }
    public Locator displayPerPages(String pageNumber){
        return page.locator(DISPLAY_PAGES).getByRole(AriaRole.OPTION, new Locator.GetByRoleOptions().setName(pageNumber));
    }
    public void selectDisplayPageNUmber(String pageNumber){
        displayPerPages(pageNumber).click();
    }
    private Locator addToCart(){
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
    }

    public void selectProduct(String ProductDescription){
        /*page.waitForLoadState();
        page.locator(PRODUCT_ITEMS)
                .filter(new Locator.FilterOptions().setHasText(ProductDescription))
                .locator(addToCart())
                .click();
       // page.pause();
        System.out.println("product "+ProductDescription+" added to cart");
        page.locator(".ajax-loading-block-window").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
*/
        //above code works  but i am capturing response from the api.
        page.waitForLoadState();
        Locator addToCart=page.locator(PRODUCT_ITEMS)
                .filter(new Locator.FilterOptions().setHasText(ProductDescription))
                .locator(addToCart());
        System.out.println("the add to cart respone api and list are below");
        Response responseAddToCart= page.waitForResponse(
                r -> r.request().method().equals("GET"),
                () -> addToCart.click()

        );
        // page.pause();
        System.out.println("product "+ProductDescription+" added to cart");
        page.locator(".ajax-loading-block-window").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));

        System.out.println("trhe response from the api are"+responseAddToCart.body()+" and URL : "+ responseAddToCart.url());
    }
    public void statuOfAddtoCart(){

        String status = page.locator(NOTIFICATION_CONFIRMATION).textContent();
        Locator notification= page.locator(NOTIFICATION_CONFIRMATION)
                .getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("shopping cart"));
        PlaywrightAssertions.assertThat(notification).isVisible();

        if(status==OutOfStock){
            System.out.println("product is out of stock");
        }
        else {
            System.out.println(AddedToCart);
            notification.click();

        }
    }


}
