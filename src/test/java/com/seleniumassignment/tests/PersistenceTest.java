package com.seleniumassignment.tests;

import com.seleniumassignment.common.BaseTest;
import com.seleniumassignment.pages.HomePage;
import com.seleniumassignment.pages.ReactExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersistenceTest extends BaseTest {

    // test persistence upon navigation

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

        // navigate off todos page
        homePage.goTo();


        // navigate back to  page
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

