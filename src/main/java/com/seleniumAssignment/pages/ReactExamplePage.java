package com.seleniumAssignment.pages;

import com.seleniumAssignment.common.BasePage;
import com.seleniumAssignment.common.WebDriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReactExamplePage extends BasePage {


    @FindBy(className = "new-todo")
    private WebElement newTodo;

    @FindBy(linkText = "Completed")
    WebElement completedList;

    @FindBy(linkText = "Active")
    WebElement ActiveList;

    @FindBy(linkText = "All")
    WebElement AllList;

    @FindBy(className = "clear-completed")
    private WebElement clearCompleted;

    @FindBy(id = "toggle-all")
    private WebElement toggleAll;

    private static final String PAGE_PATH = "/examples/react/";
    private int todoCounter = 0;

    public ReactExamplePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void addTodoItem(String text) {
        newTodo.click();
        newTodo.sendKeys(text);
        newTodo.sendKeys(Keys.ENTER);

    }

    @Step
    public void removeTodoItem(int idx) {

        if (getTodoListLength() > idx) {
            ((JavascriptExecutor) driver).executeScript("document.querySelector('.destroy').click();");
        } else {
            System.out.println("cannot remove item that its index is bigger than list size");
        }
    }

    @Step
    public void markTodoItem(int idx) {

        if (getTodoListLength() > idx) {
            WebElement el = driver.findElements(By.className("toggle")).get(idx);
            el.click();

        } else {
            System.out.println("cannot remove item that its index is bigger that list size");
        }
    }

    public void editItem(int idx, String text) {
        if (getTodoListLength() > idx) {
            List<WebElement> elements = driver.findElements(By.cssSelector("div[class=view]>label"));

            WebDriverUtils.dbClick(driver, elements.get(idx));

            WebElement el = driver.findElements(By.cssSelector("input[class=edit]")).get(idx);
            el.click();
            int len = el.getAttribute("value").length();
            while (len > 0) {
                el.sendKeys(Keys.BACK_SPACE);
                len--;
            }

            el.sendKeys(text);
            el.sendKeys(Keys.ENTER);
        }
    }

    @Step
    public int getTodoListLength() {
//        WebElement element = driver.findElement(By.className("todo-list"));
//        List<WebElement> li = element.findElements(By.tagName("li"));
        List<WebElement> elements = driver.findElements(By.cssSelector("ul[class=todo-list]>li"));

        return elements.size();

    }

    @Step
    public int getCountText() {
        if (getTodoListLength() > 0) {
            WebElement element = driver.findElement(By.className("todo-count"));
            String str = element.getText();
            return Integer.parseInt(str.replaceAll("\\D+", ""));
        }
        return 0;
    }

    @Step
    public void toggleAllItems() {
        toggleAll.click();
    }

    @Step
    public void clickOnClearCompleted() {
        clearCompleted.click();
    }

    @Override
    public String getPagePath() {
        return PAGE_PATH;
    }
}
