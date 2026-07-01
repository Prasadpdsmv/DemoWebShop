package com.stepDefinitions;

import com.pages.ApperalAndShoesPage;
import com.pages.BooksPage;
import com.pages.HomePage;
import com.pages.ShoppinCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class e2e {
    HomePage homePage= new HomePage();
    ApperalAndShoesPage apperalAndShoesPage=new ApperalAndShoesPage();
    ShoppinCartPage shoppinCartPage=new ShoppinCartPage();
    BooksPage book=new BooksPage();
    @Given("user is on {string} page")
    public void userIsOnAppearlAndShoesPage(String page) {
        homePage.navigateToHomePage();
        homePage.clickOnMenu(page);
        System.out.println(page);
    }

    @When("User selects blue jeans and clicks add to cart")
    public void userSelectsBlueJeansAndClicksAddToCart() {
        apperalAndShoesPage.clickOnApperalAndShoes();
        apperalAndShoesPage.selectProduct("Golf belt");
        apperalAndShoesPage.selectProduct("Blue jeans");

    }

    @Then("notification added to cart and shoping link will displayed")
    public void notificationAddedToCartAndShopingLinkWillDisplayed() {
        apperalAndShoesPage.statuOfAddtoCart();
    }

    @When("user clicks on shopping link")
    public void userClicksOnShoppingLink() {
        System.out.println("user clicked on shopping link");
    }

    @Then("shopping cart will open")
    public void shoppingCartWillOpen() {
        Assert.assertTrue(shoppinCartPage.verifyShoppingCartPage());
    }

    @And("user eneters coupon coode and gift card")
    public void userEnetersCouponCoodeAndGiftCard() {
        System.out.println("coupon details are not required");
    }

    @And("user selects country and state and clicks CheckOut")
    public void userSelectsCountryAndStateAndClicksCheckOut() {
        shoppinCartPage.removeItemFromShoppingCart("Golf belt");
        shoppinCartPage.selectCountryFromDropdown("United States");
        shoppinCartPage.selectStateFromDropdown("Alaska");
        shoppinCartPage.clickEstimateShopping();
        shoppinCartPage.termsConditonCheckBox();
        shoppinCartPage.selectCheckOut();


    }


    @When("User selects {string} books")
    public void userSelectsBooks(String bookName) {
        book.selectBook(bookName);

    }
}
