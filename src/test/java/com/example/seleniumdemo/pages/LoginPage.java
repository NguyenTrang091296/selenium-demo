package com.example.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By LoginHome = By.xpath("//button[text()='Login']");
    By usernameField = By.xpath("//input[@placeholder='Phone Number']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("(//button[text()='Login'])[2]");
    By successMsg = By.xpath("//span[@class='text-sm']");

    // Action methods
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void clickLoginHome() {
        driver.findElement(LoginHome).click();
    }

    public String getNameUser() {
        return driver.findElement(successMsg).getText();
    }
}
