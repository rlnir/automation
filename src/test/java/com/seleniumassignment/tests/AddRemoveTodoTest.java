package com.seleniumassignment.tests;

import com.seleniumassignment.common.BaseTest;
import com.seleniumassignment.pages.HomePage;
import com.seleniumassignment.pages.ReactExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveTodoTest extends BaseTest {

    // test add and remove functions

    @Test(groups = {"sanity"})
    public void addAndRemoveItemTest() throws InterruptedException {

        int todoItemsToAdd = 10;
        int todoItemsToRemove = 2;
        HomePage homePage = new HomePage(driver);

        System.out.println("opening home page");
        homePage.goTo();

        ReactExamplePage reactExamplePage = homePage.clickOnReact();

        for (int i = 0; i < todoItemsToAdd; i++) {
            reactExamplePage.addTodoItem("to do " + i);
        }

        for (int i = 0; i < todoItemsToRemove; i++) {
            reactExamplePage.removeTodoItem(i);
        }

        int todoListLength = reactExamplePage.getTodoListLength();
        int countText = reactExamplePage.getCountText();

        // assert length
        Assert.assertEquals(todoListLength, todoItemsToAdd - todoItemsToRemove, "items not added correctly");

        //assert counter
        Assert.assertEquals(countText, todoItemsToAdd - todoItemsToRemove, "counter should show different number");
    }


}

