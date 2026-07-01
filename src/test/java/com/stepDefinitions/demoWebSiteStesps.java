package com.stepDefinitions;

import com.pages.DemoWebsitePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class demoWebSiteStesps {
    DemoWebsitePage demoWebsitePage=new DemoWebsitePage();
    @Given("user is on demowebsite")
    public void userIsOnDemowebsite() {
        demoWebsitePage.navigateDemoWebsitePage();
    }

    @And("user clicks on widgets menu and selects date picker")
    public void userClicksOnWidgetsMenuAndSelectsDatePicker() {
        demoWebsitePage.navigateTodateDatePicker();

    }

    @And("user selects date from calender")
    public void userSelectsDateFromCalender() {
        demoWebsitePage.enterDate();
    }

    @Then("date is displayed on")
    public void dateIsDisplayedOn() {

    }

    @And("user clicks widgets menu and autosuggestions")
    public void userClicksWidgetsMenuAndAutosuggestions() {
        demoWebsitePage.navigateToAutosuggestions();
    }

    @And("user enters a letter and selects from list")
    public void userEntersALetterAndSelectsFromList() {
        demoWebsitePage.autoSuggestions();
    }

    @Then("selected element reflects in box")
    public void selectedElementReflectsInBox() {

       // demoWebsitePage.sliderBar();
        demoWebsitePage.dragAndDrop();
    }

    @And("user clicks widgets menu and selectable")
    public void userClicksWidgetsMenuAndSelectable() {
        demoWebsitePage.selectable();
    }

    @And("user selects and clicks elemnet")
    public void userSelectsAndClicksElemnet() {

    }

    @Then("user verifies")
    public void userVerifies() {
    }

    @And("user clicks widgets menu and reSizable")
    public void userClicksWidgetsMenuAndReSizable() {
        demoWebsitePage.resizibleMenu();
    }

    @Then("verifies the change in the size")
    public void verifiesTheChangeInTheSize() {
        demoWebsitePage.verifyResizable();
    }
}
