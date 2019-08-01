package tests;

import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.testng.annotations.Test;
import pages.pageLogin;
import helpers.urlFormatter;
import net.minidev.json.JSONArray;
import com.jayway.jsonpath.JsonPath;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class nativeLinkTest {
    private WebDriver driver;

    @Test(priority = 1)
    public void setUp() throws MalformedURLException {

        // Docker setup
        DesiredCapabilities caps = DesiredCapabilities.chrome();
                            caps.setPlatform(Platform.LINUX);
                            caps.setVersion("");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4545/wd/hub"),caps);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Login is part of the requirements to run every request
        pageLogin login = new pageLogin(driver);
        login.login("amilanesi@sparkdigital.com", "Jueves197");
    }

    @Test(priority = 2)
    public void getActiveAdvertiserID() {
        pageLogin cookies = new pageLogin(driver);
        cookies.getCookies();

        String body = given().
                when().
                cookies(new Cookies(cookies.getCookies())).
                get(urlFormatter.getAdvertiserURL).
                then().
                extract().
                asString();

        String status = "active";
        JSONArray id = JsonPath.read(body,"$[?(@.status=='"+status+"' )].id");

        String activeAdvertiserId = id.get(0).toString();

        given().
                when().
                cookies(new Cookies(cookies.getCookies())).
                get(urlFormatter.singleAdvertiser + activeAdvertiserId).
                then().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void getInsertionOrderID() {
        pageLogin cookies = new pageLogin(driver);
        cookies.getCookies();

        String body = given().
                when().
                cookies(new Cookies(cookies.getCookies())).
                get(urlFormatter.getInsertionOrderURL).
                then().
                extract().
                asString();

        String status = "active";
        JSONArray id = JsonPath.read(body,"$[?(@.status=='"+status+"' )].id");

        String activeIOId = id.get(0).toString();

        given().
                when().
                cookies(new Cookies(cookies.getCookies())).
                get(urlFormatter.singleInsertionOrder + activeIOId).
                then().assertThat().statusCode(200);
    }

    @Test(priority = 4)
    public void getCampaignID() {
        pageLogin cookies = new pageLogin(driver);
        cookies.getCookies();

        String body = given().
                when().
                cookies(new Cookies(cookies.getCookies())).
                get(urlFormatter.getCampaignURL).
                then().
                extract().
                asString();

        String status = "running";
        JSONArray id = JsonPath.read(body,"$[?(@.status=='"+status+"' )].id");

        String activeCampaignID = id.get(0).toString();

        given().
                when().
                cookies(new Cookies(cookies.getCookies())).
                get(urlFormatter.singleCampaign + activeCampaignID).
                then().assertThat().statusCode(200);
    }

    @Test(priority = 10)
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
