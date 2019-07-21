package com.seleniumassignment.pages;

import com.seleniumassignment.common.BasePage;
import com.seleniumassignment.utils.WebDriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReactExamplePage extends BasePage implements ITodoPage {


    @FindBy(className = "new-todo")
    private WebElement newTodo;

    @FindBy(linkText = "Completed")
    WebElement completedList;

    @FindBy(linkText = "Active")
    WebElement activeList;

    @FindBy(linkText = "All")
    WebElement allList;

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
    @Override
    public void addTodoItem(String text) {
        newTodo.click();
        newTodo.sendKeys(text);
        newTodo.sendKeys(Keys.ENTER);

    }

    @Step
    @Override
    public void removeTodoItem(int idx) {

        if (getTodoListLength() > idx) {
            WebDriverUtils.executeJs(driver, "document.querySelector('.destroy').click();");
        } else {
            System.out.println("cannot remove item that its index is bigger than list size");
        }
    }

    @Step
    @Override
    public void markTodoItem(int idx) {

        if (getTodoListLength() > idx) {
            WebElement el = driver.findElements(By.className("toggle")).get(idx);
            el.click();

        } else {
            System.out.println("cannot remove item that its index is bigger that list size");
        }
    }

    @Override
    public String getItemText(int idx) {

        if (getTodoListLength() > idx) {
            List<WebElement> elements = driver.findElements(By.cssSelector("div[class=view]>label"));
            return elements.get(idx).getText();
        }
        return null;
    }

    @Override
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

    @Override
    @Step
    public int getTodoListLength() {
//        WebElement element = driver.findElement(By.className("todo-list"));
//        List<WebElement> li = element.findElements(By.tagName("li"));
        List<WebElement> elements = driver.findElements(By.cssSelector("ul[class=todo-list]>li"));

        return elements.size();

    }

    @Override
    @Step
    public int getCountText() {
        if (getTodoListLength() > 0) {
            WebElement element = driver.findElement(By.className("todo-count"));
            String str = element.getText();
            return Integer.parseInt(str.replaceAll("\\D+", ""));
        }
        return 0;
    }

    @Override
    @Step
    public void toggleAllItems() {
        toggleAll.click();
    }

    @Override
    @Step
    public void clickOnClearCompleted() {
        clearCompleted.click();
    }

    @Override
    public String getPagePath() {
        return PAGE_PATH;
    }

    @Override
    public HomePage previousPage() {
        return new HomePage(driver);
    }

    @Override
    @Step
    public void filterCompleted() {
        completedList.click();
    }

    @Override
    @Step
    public void filterActive() {
        activeList.click();
    }

    @Override
    @Step
    public void filterAll() {
        allList.click();
    }
}
