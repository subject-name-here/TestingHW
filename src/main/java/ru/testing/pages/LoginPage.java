package ru.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String login, String password) {
        driver.navigate().to("http://localhost:8080/login");

        String loginId = "id_l.L.login";
        String passwordId = "id_l.L.password";
        String submitId = "id_l.L.loginButton";

        driver.findElement(By.id(loginId)).sendKeys(login);
        driver.findElement(By.id(passwordId)).sendKeys(password);
        driver.findElement(By.id(submitId)).click();
    }
}
