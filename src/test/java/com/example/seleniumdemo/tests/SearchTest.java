package com.example.seleniumdemo.tests;
import com.example.seleniumdemo.steps.LoginSteps;
import io.qameta.allure.testng.AllureTestNg;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

@Listeners({ AllureTestNg.class })
public class SearchTest {
    WebDriver driver;
    LoginSteps loginSteps;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TRANG\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginSteps = new LoginSteps(driver);
    }
    @Test
    public void searchCar() {
        System.out.println("Go to Car for Sale");
        driver.get("https://www.libertycarz.com/products/sale-cars");
        WebElement searchBox = driver.findElement(By.xpath("(//input[@placeholder =\"Search For Your Favourite Cars\"])[1]"));
        searchBox.sendKeys("Toyota Prius 2005");
        WebElement searchBtn = driver.findElement(By.xpath("(//button[@title=\"SEARCH\"])[1]"));
        searchBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean isTextVisible = wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//div[@class = 'result']")),
                "395 Used cars in LibertyCarz App"
        ));

        if (isTextVisible) {
            System.out.println("Search results are displayed correctly.");

        }
    }
}
