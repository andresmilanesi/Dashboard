package helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;


public class helpers {

    // This timestamp is used to generate unique data
    public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    public String urlTimestamp = format.format(new Date());

    // This helper pauses the script when needed
    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElement(WebDriver driver, By webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds.
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
        wait.until(ExpectedConditions.presenceOfElementLocated(webelement));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webelement));
    }

    public void waitForElementGone(WebDriver driver, By webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(webelement));
    }

    public void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

}
