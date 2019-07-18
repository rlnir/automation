package com.seleniumAssignment.tests;

import com.seleniumAssignment.common.BaseTest;
import com.seleniumAssignment.common.WebDriverUtils;
import com.seleniumAssignment.pages.HomePage;
import com.seleniumAssignment.pages.ReactExamplePage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddRemoveTodoTest extends BaseTest {

    @Test
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

