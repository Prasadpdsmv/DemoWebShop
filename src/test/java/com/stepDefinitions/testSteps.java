package com.stepDefinitions;

import com.pages.ShoppinCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class testSteps {
    ShoppinCartPage shoppinCartPage=new ShoppinCartPage();

    @Given("user is on shopping Cart")
    public void userIsOnShoppingCart() {
        shoppinCartPage.testRun();
        shoppinCartPage.removeItemFromShoppingCart(" Rockabilly Polka Dot Top JR Plus Size");

    }

    @And("user ckeck the product checkbox")
    public void userCkeckTheProductCheckbox() {
        System.out.println("done");
    }
}
