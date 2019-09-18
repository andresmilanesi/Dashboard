package pages;

import dataProviders.configFileReader;
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
    private dataProviders.configFileReader configFileReader= new configFileReader();

    public pageLogin(WebDriver driver) {
        this.driver = driver;
        userField = By.id("login-email");
        passField = By.id("login-pass");
        signinButton = By.cssSelector("button[type='submit']");
    }

    // This function is used to login into the app with user and password provided in configuration file
    public void login() {
        driver.navigate().to(configFileReader.getEnvironmentUrl());
        helpers helper = new helpers();
        helper.waitForElement(driver, userField);
        driver.findElement(userField).sendKeys(configFileReader.getUser());
        driver.findElement(passField).sendKeys(configFileReader.getPassword());
        driver.findElement(signinButton).click();
        System.out.print(" Login in...");

    }

    // This function is used to store the session cookies
    public List getCookies() {
        Set<Cookie> seleniumCookies = driver.manage().getCookies();
        List restAssuredCookies = new ArrayList();
        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            restAssuredCookies.add(new io.restassured.http.Cookie.Builder(cookie.getName(), cookie.getValue()).build());
        }
        return restAssuredCookies;

    }


}
