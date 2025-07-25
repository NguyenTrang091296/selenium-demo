package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void loginAs(String username, String password) {
        loginPage.clickLoginHome();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public boolean isLoginSuccessful(String NameUser ) {
        return loginPage.getNameUser().contains(NameUser);
    }
}
