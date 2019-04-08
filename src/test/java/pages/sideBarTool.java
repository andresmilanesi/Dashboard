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
        advertiserTool = By.xpath("//ul[contains(@class, 'sidebar-tools list-group j-sidebar')]/li[2]");
        newAdvertiserButton = By.xpath("//ul[contains(@class, 'sidebar-tools list-group j-sidebar')]/li[4]");
    }

    // This is the function used to browse to advertiser form
    public void goToAdvertiserForm() {
        helpers helper = new helpers();
        helper.waitForPageLoadComplete(driver, 40);
        helper.waitForElement(driver, advertiserTool);
        driver.findElement(advertiserTool).click();
        driver.findElement(newAdvertiserButton).click();
        System.out.print(" Moving to Advertiser Form page.");
    }

}