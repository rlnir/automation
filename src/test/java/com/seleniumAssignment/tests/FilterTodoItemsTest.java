package com.seleniumAssignment.tests;

import com.seleniumAssignment.common.BaseTest;
import com.seleniumAssignment.common.WebDriverUtils;
import com.seleniumAssignment.pages.HomePage;
import com.seleniumAssignment.pages.ReactExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTodoItemsTest extends BaseTest {

    int todoItemsToAdd = 10;
    int todoItemsToMark = 6;

    @Test
    public void filterCompletedTest() throws InterruptedException {


        HomePage homePage = new HomePage(driver);

        System.out.println("opening home page");
        homePage.goTo();

        ReactExamplePage reactExamplePage = homePage.clickOnReact();

        reactExamplePage.filterActive();

        int todoListLength = reactExamplePage.getTodoListLength();
        int countText = reactExamplePage.getCountText();
        
        // assert length
        Assert.assertEquals(todoListLength, todoItemsToAdd - todoItemsToMark, "items not added correctly");

        //assert counter
        Assert.assertEquals(countText, todoItemsToAdd - todoItemsToMark, "counter should show different number");
    }

    @Test
    public void filterActiveTest() throws InterruptedException {

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

        reactExamplePage.filterCompleted();

        int todoListLength = reactExamplePage.getTodoListLength();
        int countText = reactExamplePage.getCountText();

        Thread.sleep(3000);

        // assert length
        Assert.assertEquals(todoListLength, todoItemsToMark, "items not added correctly");

        //assert counter
        Assert.assertEquals(countText, todoItemsToAdd - todoItemsToMark, "counter should show different number");
    }


}

