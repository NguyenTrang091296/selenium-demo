package test.java;
import io.qameta.allure.testng.AllureTestNg;

import org.testng.annotations.Listeners;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import steps.LoginSteps;


@Listeners({ AllureTestNg.class })
public class LoginTest {
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
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Java Tutorial");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Hoàn tất tìm kiếm");
    }
    @Test
    public void loginLibertyCarz() {
        driver.get("https://www.libertycarz.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        System.out.println("Hoàn tất nhấn vào News & Events");
        System.out.println("Login vào hệ thống liberty Carz");
        loginSteps.loginAs("015935504", "Aa1234@1234");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
