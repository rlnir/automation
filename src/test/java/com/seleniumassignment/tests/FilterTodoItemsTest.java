package com.seleniumassignment.tests;

import com.seleniumassignment.common.BaseTest;
import com.seleniumassignment.pages.HomePage;
import com.seleniumassignment.pages.ReactExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTodoItemsTest extends BaseTest {

    private int todoItemsToAdd = 10;
    private int todoItemsToMark = 6;

    // test active filter

    @Test(groups = {"sanity"})
    public void filterActiveTest() {


        HomePage homePage = new HomePage(driver);

        System.out.println("opening home page");
        homePage.goTo();

        ReactExamplePage reactExamplePage = homePage.clickOnReact();

        for (int i = 0; i < todoItemsToAdd; i++) {
            reactExamplePage.addTodoItem("to do " + i);
        }

        for (int i = 0; i < todoItemsToMark; i++) {
            reactExamplePage.markTodoItem(i);
        }

        // click filter
        reactExamplePage.filterActive();

        int todoListLength = reactExamplePage.getTodoListLength();
        int countText = reactExamplePage.getCountText();

        // assert length
        Assert.assertEquals(todoListLength, todoItemsToAdd - todoItemsToMark, "items not added correctly");

        //assert counter
        Assert.assertEquals(countText, todoItemsToAdd - todoItemsToMark, "counter should show different number");
    }

    // test completed filter

    @Test(groups = {"sanity"})
    public void filterCompletedTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        System.out.println("opening home page");
        homePage.goTo();

        ReactExamplePage reactExamplePage = homePage.clickOnReact();

        for (int i = 0; i < todoItemsToAdd; i++) {
            reactExamplePage.addTodoItem("to do " + i);
        }

        for (int i = 0; i < todoItemsToMark; i++) {
            reactExamplePage.markTodoItem(i);
        }

        // click filter
        reactExamplePage.filterCompleted();

        int todoListLength = reactExamplePage.getTodoListLength();
        int countText = reactExamplePage.getCountText();

        // assert length
        Assert.assertEquals(todoListLength, todoItemsToMark, "items not added correctly");

        //assert counter
        Assert.assertEquals(countText, todoItemsToAdd - todoItemsToMark, "counter should show different number");
    }


}

