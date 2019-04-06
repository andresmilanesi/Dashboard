package pages;

import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageCampaignForm {
    private WebDriver driver;
    // Campaing form elements
    private By campaingNameField;
    private By endDateCalendar;
    private By impressionTargetField;
    private By createAndMediaButton;
    private By openGoalRadio;
    private By currentDayCalendarButton;
    private By applyCalendarButton;

    public pageCampaignForm(WebDriver driver) {
        this.driver = driver;
        campaingNameField = By.className("j-campaign-name");
        endDateCalendar = By.cssSelector(".j-campaign-endDate");
        impressionTargetField = By.cssSelector(".j-campaign-impressionsTarget");
        createAndMediaButton = By.id("campaign-create-and-navigate-btn");
        openGoalRadio = By.xpath("//*[@id='j-field-container-goal']/c6-radio/div/div[3]");
        currentDayCalendarButton = By.cssSelector(".available.today.active.start-date.end-date");
        applyCalendarButton = By.cssSelector(".applyBtn.btn.btn-small.btn-sm.btn-success");
    }

    public void createCampaign(String name, int impressions) {
        helpers helper = new helpers();
        helper.waitForElement(driver, campaingNameField);
        driver.findElement(campaingNameField).sendKeys(name);
        helper.waitForElement(driver, endDateCalendar);
        driver.findElement(endDateCalendar).click();
        helper.waitForElement(driver, currentDayCalendarButton);
        driver.findElement(currentDayCalendarButton).click();
        helper.waitForElement(driver, applyCalendarButton);
        driver.findElement(applyCalendarButton).click();
        driver.findElement(impressionTargetField).sendKeys(Integer.toString(impressions));
        helper.waitForElement(driver, createAndMediaButton);
        driver.findElement(createAndMediaButton).click();
    }
}
