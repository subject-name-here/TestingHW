package ru.testing.pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class NewIssueFormTest {

    private WebDriver driver;
    private String lastIssue;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("root", "root");

        Wait<WebDriver> wait = new WebDriverWait(driver, 2);
        wait.until((ExpectedCondition<Boolean>) driver -> driver.getCurrentUrl().endsWith("dashboard"));

        driver.navigate().to("http://localhost:8080/issues");

        IssuesPage issuesPage = new IssuesPage(driver);
        lastIssue = issuesPage.getLastIssueId();
        issuesPage.clickOnCreateNewIssue();
    }

    @After
    public void after() {
        driver.close();
    }

    private boolean isFailed() {

        int num_of_refreshes = 3;
        while (num_of_refreshes > 0) {
            driver.navigate().to("http://localhost:8080/issues");
            if (!new IssuesPage(driver).getLastIssueId().equals(lastIssue)) {
                return false;
            }
            num_of_refreshes--;
        }
        return true;
    }

    @Test
    public void test0() {}

    @Test
    public void test1() {
        NewIssueForm form = new NewIssueForm(driver);
        form.createIssue("Some summary", "Some description");
        assertFalse(isFailed());
    }

    @Test
    public void test2() {
        NewIssueForm form = new NewIssueForm(driver);
        form.createIssue("Some summary", "");
        assertFalse(isFailed());
    }

    @Test
    public void test3() {
        NewIssueForm form = new NewIssueForm(driver);
        form.createIssue("", "Some description");
        assertTrue(isFailed());
    }

    @Test
    public void test4() {
        NewIssueForm form = new NewIssueForm(driver);
        form.createIssue("", "");
        assertTrue(isFailed());
    }
}