package ru.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.testing.elements.Button;

public class IssuesPage {
    private Button issueButton;
    private WebDriver driver;

    public IssuesPage(WebDriver driver) {
        this.driver = driver;

        Wait<WebDriver> wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("issues-center")));

        String issueButtonClass = "yt-header__create-btn";
        issueButton = new Button(driver, issueButtonClass);
    }

    public void clickOnCreateNewIssue() {
        issueButton.click();
    }

    public String getLastIssueId() {
        return driver.findElements(By.className("issueContainer"))
                .get(0)
                .findElement(By.className("issueId")).getText();
    }
}
