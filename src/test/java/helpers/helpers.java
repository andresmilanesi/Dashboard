package helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class helpers {
    // This timestamp is used to generate unique data
    public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    // This helper pauses the script when needed
    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void waitForLoadComplete(ChromeDriver driver) {
//        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//                    }
//                };
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(pageLoadCondition);
//    }

    public void waitForElementPresent(WebDriver driver, By webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds.
        wait.until(ExpectedConditions.presenceOfElementLocated(webelement));
    }

    public void waitForElementClickable(WebDriver driver, By webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds.
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
    }

    public void waitForElement(WebDriver driver, By webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 45); // Wait for 45 seconds.
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
        wait.until(ExpectedConditions.presenceOfElementLocated(webelement));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webelement));

    }

    public void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

}
