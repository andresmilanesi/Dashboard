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
    public static final String campaign_base_url = "https://managedev3genint1.altitude-arena.com/manage/campaigns";

    public pageCampaignForm(WebDriver driver) {
        this.driver = driver;
        campaingNameField = By.className("j-campaign-name");
        endDateCalendar = By.id("form-field-endDate");
        impressionTargetField = By.cssSelector(".j-campaign-impressionsTarget");
        createAndMediaButton = By.id("campaign-create-and-navigate-btn");
        openGoalRadio = By.xpath("//*[@id='j-field-container-goal']/c6-radio/div/div[3]");
        currentDayCalendarButton = By.cssSelector(".available.today.active.start-date.end-date");
        applyCalendarButton = By.linkText("Apply");
    }

    public void createCampaign(String name) {
        helpers helper = new helpers();
        helper.pause(8000);
        helper.waitForElement(driver, campaingNameField);
        driver.findElement(campaingNameField).sendKeys(name);
        driver.findElement(openGoalRadio).click();
        driver.findElement(createAndMediaButton).click();
        System.out.print(" Created a Campaign and moving to Media form.");
    }
}
