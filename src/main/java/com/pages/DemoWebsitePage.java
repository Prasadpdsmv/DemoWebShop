package com.pages;

import com.baseUtility.PLaywrightUtility;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoWebsitePage extends PLaywrightUtility {

    private static final Logger log = LoggerFactory.getLogger(DemoWebsitePage.class);
    public String WIDGETS_MENU="Widgets";
    private String INTERACTIONS="Interactions";

    private Locator selectMenu(String menu){
     /* return   page.locator("ul.nav navbar-nav")
                .filter(new Locator.FilterOptions().setHasText(menu));*/
    return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menu));
    }


    public void navigateTodateDatePicker(){
        selectMenu(WIDGETS_MENU).hover();
       // page.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(" Datepicker ")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Datepicker")).click();
    }
    public void navigateDemoWebsitePage(){
        page.navigate("https://demo.automationtesting.in/Register.html");
        page.waitForLoadState(LoadState.LOAD);
    }
    public void enterDate(){
        page.locator("#datepicker2").click();
        page.getByTitle("Change the month")
                        .selectOption("January");

        page.getByTitle("Change the year")
                .selectOption(new SelectOption().setIndex(0));

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("13")).click();
    }

    public void autoSuggestions(){
        page.getByRole(AriaRole.TEXTBOX).fill("j");

        /*page.getByRole(AriaRole.LINK)
                .filter(new Locator.FilterOptions().setHasText("Jamaica"))
                .click();*/
        page.getByText("Jamaica").click();

        log.trace("this is from auto suggestions");
    }
    public void navigateToAutosuggestions(){
        selectMenu(WIDGETS_MENU).hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AutoComplete")).click();
    }
    public void sliderBar(){
        //selectMenu(WIDGETS_MENU).click();
        selectMenu(WIDGETS_MENU).hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Slider")).click();

        page.locator(".ui-slider-handle")
                .evaluate("element => element.style.left='90%'");
        log.trace("da");
    }

    public void dragAndDrop(){
        selectMenu(INTERACTIONS).hover();
       // page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drag and Drop ")).hover();
        page.getByText("Drag and Drop").hover();
       // page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Static")).click();

        // for dynamic dropm
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dynamic")).click();

        page.waitForLoadState();

        Locator sourceDrag=page.locator("#angular");
        Locator targetDrop=page.locator("#droparea");

        Locator sourceDrag2=page.locator("#mongo");





        //sourceDrag.dragTo(dynamicDrop);

        sourceDrag.hover();
        page.mouse().down();
        page.mouse().move(500, 300);

        //page.pause();

        Locator dynamicDrop=page.locator("#msg").locator("div");
        dynamicDrop.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.ATTACHED));

        BoundingBox targetBox=dynamicDrop.boundingBox();
        page.mouse().move( targetBox.x + targetBox.width/2,
                targetBox.y + targetBox.height/2);
        page.mouse().up();

        sourceDrag2.hover();
        page.mouse().down();
        page.mouse().move(500, 300);

        System.out.println();
        page.waitForLoadState();

        Locator dynamicDrop2=page.locator("#msg").locator("div").nth(1);
        dynamicDrop2.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.ATTACHED));

        BoundingBox targetBox2=dynamicDrop2.boundingBox();

        page.mouse().move( targetBox2.x + targetBox2.width/2,
                targetBox2.y + targetBox2.height/2);
        page.mouse().up();

        log.trace("this is from drag and drop");

        /*Download download=page.waitForDownload(() ->{
            page.locator("sample").click();
        });
        download.saveAs(
                Paths.get("")
        );*/

    }
    public void selectable(){
        selectMenu(INTERACTIONS).hover();
        page.getByText("Selectable").click();
        page.waitForLoadState();
       Locator locator=page.locator("//ul[@class='deaultFunc']");


        //PlaywrightAssertions.assertThat(locator).hasAttribute("", "" );

        System.out.println("attribute value:  "+locator.getAttribute("class"));

        System.out.println("list and the values "+locator.textContent());

        System.out.println("list items and the valures"+ locator.filter(new Locator.FilterOptions().setHas(page.getByRole(AriaRole.LISTITEM))));

       Locator item1= locator.
                filter(new Locator.FilterOptions().setHasText("Sakinalium - Readability"));
        System.out.println("before click the attribute value :   "+item1.getAttribute("class"));

        item1.click();

        System.out.println("After click the attirbute value :   "+item1.getAttribute("class"));

        Locator item11=locator.getByRole(AriaRole.LISTITEM)
                        .filter(new Locator.FilterOptions().setHasText("Sakinalium - Extent Reports"));

        System.out.println("before attribute value : "+item11.getAttribute("class"));

        item11.click();

        System.out.println("After attribute value :  "+ item11.getAttribute("class"));

    }
    public void resizibleMenu(){
        selectMenu(INTERACTIONS).hover();
        page.getByText("Resizable").click();
        page.waitForLoadState();

        System.out.println("the generic values "+page.getByRole(AriaRole.GENERIC));
    }
    public void verifyResizable(){
        Locator boxDimensions=page.locator("#resizable");


        System.out.println(boxDimensions);

        BoundingBox dimensions=boxDimensions.boundingBox();
        double moveToValue= dimensions.x+ dimensions.width+200;
        double movoteYvalue= dimensions.y+ dimensions.height/2;
        System.out.println(dimensions);

        Locator boxWidth=page.locator("//div[@class='ui-resizable-handle ui-resizable-e']");
        boxWidth.hover();
        page.mouse().down();
        page.mouse().move(moveToValue, moveToValue);

    }
}
