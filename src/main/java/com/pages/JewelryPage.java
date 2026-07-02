package com.pages;

import com.baseUtility.PlaywrightManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class JewelryPage {
    private final Page page;


    private final Locator loginLink;
    private final Locator registerLink;
    private final Locator shoppingCartLink;
    private final Locator searchInput;
    private final Locator searchButton;


    private final Locator jewelryCategoryLink;

    private final Locator sortByDropdown;
    private final Locator displayPerPageDropdown;
    private final Locator viewModeDropdown;


    private final Locator createYourOwnJewelry;
    private final Locator blackAndWhiteDiamondHeart;
    private final Locator diamondPaveEarrings;

    public JewelryPage() {
        this.page = PlaywrightManager.page();


        this.loginLink = page.locator(".ico-login");
        this.registerLink = page.locator(".ico-register");
        this.shoppingCartLink = page.locator(".ico-cart");
        this.searchInput = page.locator("#small-searchterms");
        this.searchButton = page.locator(".button-1.search-box-button");


        this.jewelryCategoryLink = page.locator(".header-menu a:has-text('JEWELRY')");

        this.sortByDropdown = page.locator("#products-orderby");
        this.displayPerPageDropdown = page.locator("#products-pagesize");
        this.viewModeDropdown = page.locator("#products-viewmode");

        this.createYourOwnJewelry = page.locator(".product-item:has-text('Create Your Own Jewelry')");
        this.blackAndWhiteDiamondHeart = page.locator(".product-item:has-text('Black & White Diamond Heart')");
        this.diamondPaveEarrings = page.locator(".product-item:has-text('Diamond Pave Earrings')");
    }



    public void navigateToJewelry() {
        jewelryCategoryLink.click();
    }

    public void searchProduct(String productName) {
        searchInput.fill(productName);
        searchButton.click();
    }

    public void sortProductsBy(String value) {
        // Values: "5" (Name: A to Z), "6" (Name: Z to A), "10" (Price: Low to High), etc.
        sortByDropdown.selectOption(new SelectOption().setValue(value));
    }

    public void addProductToCart(String productName) {
        page.locator(".product-item")
            .filter(new Locator.FilterOptions().setHasText(productName))
            .locator(".product-box-add-to-cart-button")
            .click();
    }

    public void goToCart() {
        shoppingCartLink.click();
    }

    public boolean isProductVisible(String productName) {
        return page.locator(".product-item").filter(new Locator.FilterOptions().setHasText(productName)).isVisible();
    }
}
