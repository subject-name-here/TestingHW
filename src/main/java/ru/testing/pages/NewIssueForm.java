package ru.testing.pages;

import org.openqa.selenium.WebDriver;
import ru.testing.elements.Button;
import ru.testing.elements.TextField;

public class NewIssueForm {
    private TextField summary;
    private TextField description;
    private Button close;
    private Button createIssue;

    public NewIssueForm(WebDriver driver) {
        String summaryClass = "edit-summary";
        summary = new TextField(driver, summaryClass);
        String descriptionClass = "edit-description";
        description = new TextField(driver, descriptionClass);

        String closeClass = "edit-close-lnk";
        close = new Button(driver, closeClass);
        String createIssueClass = "submit-btn";
        createIssue = new Button(driver, createIssueClass);
    }

    public void createIssue(String summary, String description) {
        setSummary(summary);
        setDescription(description);
        submitIssue();
    }

    public void setSummary(String summary) {
        this.summary.setFieldContent(summary);
    }

    public void setDescription(String description) {
        this.description.setFieldContent(description);
    }

    public void submitIssue() {
        createIssue.click();
    }

    public void discardIssue() {
        close.click();
    }

}
