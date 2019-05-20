package ru.testing.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextField {
    private WebElement textField;
    public TextField(WebDriver driver, String className) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        textField = driver.findElement(By.className(className));
    }

    public void setFieldContent(String text) {
        textField.clear();
        textField.sendKeys(text);
    }
}
