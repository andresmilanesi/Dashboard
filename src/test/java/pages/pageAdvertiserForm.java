package pages;

import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageAdvertiserForm {
    private WebDriver driver;
    // Advertiser form elements
    private By advertiserName;
    public static By CPM;
    public static By PCPM;
    public static By CPMandPCPM;
    private By contactNameField;
    private By contactEmailField;
    private By contactPhoneField;
    private By companyAddressField;
    private By createAdvertiserAndIOButton;
    public static final String base_url = "https://managedev4genint1.altitude-arena.com/manage/advtsrs";

    public pageAdvertiserForm(WebDriver driver) {
        this.driver = driver;
        // Advertiser form locators
        advertiserName = By.cssSelector(".j-advertiser-name");
        CPM = By.cssSelector("div[class='radio-inline fancy ng-scope selected']");
        PCPM = By.cssSelector("div[class='radio-inline fancy ng-scope']");
        CPMandPCPM = By.name("153");
        contactNameField = By.className("j-advertiser-contactName");
        contactEmailField = By.className("j-advertiser-contactEmail");
        contactPhoneField = By.className("j-advertiser-contactPhone");
        companyAddressField = By.className("j-advertiser-contactAddress");
        createAdvertiserAndIOButton = By.cssSelector(".j-advertiser-create-and-navigate");
    }


    // This is the function used to complete and submit advertiser form
    public void createAdvertiser(String name, By pricing ,String contactName, String contactEmail, String contactPhone, String companyAddress) {
        helpers helper = new helpers();
        helper.waitForPageLoadComplete(driver, 40);
        helper.waitForElement(driver, advertiserName);
        driver.findElement(advertiserName).sendKeys(name);
        driver.findElement(pricing).click();
        driver.findElement(contactNameField).sendKeys(contactName);
        driver.findElement(contactEmailField).sendKeys(contactEmail);
        driver.findElement(contactPhoneField).sendKeys(contactPhone);
        driver.findElement(companyAddressField).sendKeys(companyAddress);
        helper.waitForElementClickable(driver, createAdvertiserAndIOButton);
        driver.findElement(createAdvertiserAndIOButton).click();
        System.out.print(" Created an Advertiser and moving to IO form.");
    }

}