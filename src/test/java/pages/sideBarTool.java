package pages;

import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sideBarTool {
    private WebDriver driver;
    // Sidebar webelements
    private By advertiserTool;
    private By newAdvertiserButton;

    public sideBarTool(WebDriver driver) {
        this.driver = driver;
        // Sidebar locators
        advertiserTool = By.xpath("//*[@id='sidebar-wrapper']/ul/li[4]");
        newAdvertiserButton = By.xpath("//*[@id='sidebar-wrapper']/ul/li[6]");
    }

    // This is the function used to browse to advertiser form
    public void goToAdvertiserForm() {
        helpers helper = new helpers();
        helper.waitForElement(driver, advertiserTool);
        driver.findElement(advertiserTool).click();
        helper.waitForElement(driver, newAdvertiserButton);
        driver.findElement(newAdvertiserButton).click();
        System.out.print(" Moving to Advertiser Form page.");
    }

}