package pages;

import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageLogin {
    private WebDriver driver;
    private By userField;
    private By passField;
    private By signinButton;
    // This aims to QA4 env
    private static final String base_url = "https://managedev4genint1.altitude-arena.com/login";

    public pageLogin(WebDriver driver) {
        this.driver = driver;
        userField = By.id("login-email");
        passField = By.id("login-pass");
        signinButton = By.cssSelector("button[type='submit']");
    }

    // This is the login function
    public void login(String user, String pass) {
        driver.navigate().to(base_url);
        helpers helper = new helpers();
        helper.waitForElement(driver, userField);
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passField).sendKeys(pass);
        helper.waitForElement(driver, signinButton);
        driver.findElement(signinButton).click();
        System.out.print(" Login in...");
    }
}
