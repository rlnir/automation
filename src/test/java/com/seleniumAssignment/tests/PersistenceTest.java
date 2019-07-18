package com.seleniumAssignment.tests;

import com.seleniumAssignment.common.BasePage;
import com.seleniumAssignment.common.BaseTest;
import com.seleniumAssignment.pages.HomePage;
import com.seleniumAssignment.pages.ReactExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersistenceTest extends BaseTest {

    @Test(groups = {"sanity"})
    public void listSavedUponNavigationTest() throws InterruptedException {

        int todoItemsToAdd = 5;
        String text = "changed";

        HomePage homePage = new HomePage(driver);

        System.out.println("opening home page");
        homePage.goTo();


        System.out.println("go to react page");
        ReactExamplePage reactExamplePage = homePage.clickOnReact();


        for (int i = 0; i < todoItemsToAdd; i++) {
            reactExamplePage.addTodoItem("to do " + i);
        }

        homePage.goTo();

        reactExamplePage = homePage.clickOnReact();

        int todoListLength = reactExamplePage.getTodoListLength();
        int countText = reactExamplePage.getCountText();

        // assert length
        Assert.assertEquals(todoListLength, todoItemsToAdd, "items not added correctly");

        //assert counter
        Assert.assertEquals(countText, todoItemsToAdd, "counter should show different number");

        Thread.sleep(3000);

    }


}

