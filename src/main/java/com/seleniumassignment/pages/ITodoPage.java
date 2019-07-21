package com.seleniumassignment.pages;

import io.qameta.allure.Step;

/**
 * use this interface with TodoExamples pages for each language
 */

public interface ITodoPage {
    @Step
    void addTodoItem(String text);

    @Step
    void removeTodoItem(int idx);

    @Step
    void markTodoItem(int idx);

    String getItemText(int idx);

    void editItem(int idx, String text);

    @Step
    int getTodoListLength();

    @Step
    int getCountText();

    @Step
    void toggleAllItems();

    @Step
    void clickOnClearCompleted();

    void filterCompleted();

    void filterActive();

    void filterAll();
}
