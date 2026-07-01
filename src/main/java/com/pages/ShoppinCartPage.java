package com.pages;

import com.baseUtility.PLaywrightUtility;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import lombok.extern.slf4j.Slf4j;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@Slf4j
public class ShoppinCartPage extends PLaywrightUtility {
   // Page page;
    String INPUT_COUPON_CODE="input[name='discountcouponcode']";
    String ADD_GIFT_CARD="Add gift card";
    String DROPDOWN_COUNTRY="Country:";
    String DROPDOWN_STATE="State / province:";
    String ESTIMATE_SHOPPING="Estimate shipping";
    String TERMS_CHECK_BOX="#termsofservice";
    String CHECK_OUT="checkout";
    String SHOPPING_CART_TABLE="cart";
    String UPDATE_SHOPPING_CART="name='updatecart'";
    String CONTINUE_SHOPPING="name='continueshopping'";
    String SHOPPING_CART_HEADING="Shopping cart";
    String CHECK_BOX="input[type='checkbox']";



    public void enterCoupnCode(String coupon){
        page.locator(INPUT_COUPON_CODE).fill(coupon);
      //  page.locator("//input[@name='applydiscountcouponcode']").click();
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(ADD_GIFT_CARD))
                .click();

    }
    public boolean verifyShoppingCartPage(){
       return page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(SHOPPING_CART_HEADING)).isVisible();
    }
    public void selectCountryFromDropdown(String countryName){
        page.getByLabel(DROPDOWN_COUNTRY)
                .selectOption(new SelectOption().setLabel(countryName));
    }
    public void selectStateFromDropdown(String stateName){
        page.getByLabel(DROPDOWN_STATE)
                .selectOption(new SelectOption().setLabel(stateName));
      //  assertThat(page.getByLabel("Subscribe to newsletter")).isChecked();

    }
    public void clickEstimateShopping(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ESTIMATE_SHOPPING))
                .click();
    }
    public void termsConditonCheckBox(){
        page.locator(TERMS_CHECK_BOX).check();
    }
    public void selectCheckOut(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(CHECK_OUT))
                .click();
    }
    public void removeItemFromShoppingCart(String productDetails){
/*        page.getByRole(AriaRole.TABLE, new Page.GetByRoleOptions().setName(SHOPPING_CART_TABLE))
                .filter(new Locator.FilterOptions().setHasText(productDetails))
                .getByRole(AriaRole.CELL)
                .getByRole(AriaRole.CHECKBOX)
                .check();*/
      //  page.pause();
       // System.out.println( page.locator("table.cart").textContent());
       // System.out.println("*********the table ended ***********");
      //  System.out.println(page.locator("tbody").locator("tr").nth(0).textContent());

       /* System.out.println( page.locator("table.cart")
                .filter(new Locator.FilterOptions().s
                .textContent());

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("golf belt"));
        */


        page.locator("tr.cart-item-row")
                .filter(new Locator.FilterOptions().setHasText(productDetails))
                .locator(CHECK_BOX)
                .check();
       // page.pause();



    }
    public void testRun(){
        page.navigate("https://demowebshop.tricentis.com/cart");

    }
}
