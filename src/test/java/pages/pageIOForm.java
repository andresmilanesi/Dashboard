package pages;

import helpers.helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class pageIOForm {
    private WebDriver driver;
    private By nameField;
    private By contactNameField;
    private By contactEmailField;
    private By createAndCampaignButton;

    public pageIOForm(WebDriver driver) {
        this.driver = driver;
        nameField = By.cssSelector(".j-insertionOrder-name");
        contactNameField = By.className("j-insertionOrder-primaryContactName");
        contactEmailField = By.className("j-insertionOrder-primaryContactEmail");
        createAndCampaignButton = By.cssSelector(".j-insertionOrder-create-and-navigate");
    }

    public void completeIOForm(String name, String contactName, String contactEmail) {
        helpers helper = new helpers();
        helper.waitForPageLoadComplete(driver, 50);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(contactNameField).sendKeys(contactName);
        driver.findElement(contactEmailField).sendKeys(contactEmail);
        helper.waitForElementClickable(driver, createAndCampaignButton);
        driver.findElement(createAndCampaignButton).click();
        System.out.print(" Completed IO form, moving to campaign form.");
    }
}
