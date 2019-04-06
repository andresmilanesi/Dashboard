package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import pages.*;
import helpers.helpers;

public class dashboardRegressionTest {
    private WebDriver driver;

    // What we are going to run before tests execution.
    @BeforeMethod

    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "/home/amilanesi/Work/Automation/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    // What we are going to run after the tests execution.
    @AfterMethod

    public void tearDown() {
        driver.close();
        driver.quit();
    }

    // This will test the demand flow,
    @Test(priority=1)
    public void demandFlowTest() {
        helpers helper = new helpers();
        pageLogin login = new pageLogin(driver);
        login.login("amilanesi@sparkdigital.com", "Jueves197");
        // Go to new advertiser form.
//        helper.pause(5000);
        sideBarTool create = new sideBarTool(driver);
        create.goToAdvertiserForm();
        // Complete new advertiser form and submit, user is taken to IO form.
//        helper.pause(5000);
        pageAdvertiserForm createAdver = new pageAdvertiserForm(driver);
        createAdver.createAdvertiser("Automated Advertiser " + helpers.timestamp, pageAdvertiserForm.CPM,
                "Andy Contact " + helpers.timestamp, "automatedAdvertiserContact@test.com",
                "123456789", "Hello 123");
        // Complete new IO form and submit, user is taken to Campaign form.
////        helper.pause(5000);
        pageIOForm createIO = new pageIOForm(driver);
        createIO.completeIOForm("Automated IO " + helpers.timestamp, "Automated Contact",
                "automatedIOContact@test.com");
        // Complete campaign form and submit, user is taken to media form.
//        helper.pause(5000);
        pageCampaignForm createCamp = new pageCampaignForm(driver);
        createCamp.createCampaign("Automated Campaign " + helpers.timestamp, 10);
        // Complete media form and submit, user is taken to
        helpers pause = new helpers();
        pause.pause(10000);
    }


}