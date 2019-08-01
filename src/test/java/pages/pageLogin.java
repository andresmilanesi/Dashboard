package pages;

import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class pageLogin {
    private WebDriver driver;
    private By userField;
    private By passField;
    private By signinButton;
    // This aims to QA4 env
    private static final String base_url = "https://managedev3genint1.altitude-arena.com/login";

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
        driver.findElement(signinButton).click();
        System.out.print(" Login in...");

    }

    public List getCookies() {
        Set<Cookie> seleniumCookies = driver.manage().getCookies();
        List restAssuredCookies = new ArrayList();
        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            restAssuredCookies.add(new io.restassured.http.Cookie.Builder(cookie.getName(), cookie.getValue()).build());
        }
        return restAssuredCookies;

    }


}
