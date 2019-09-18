package pages;

import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageMediaForm {

    private WebDriver driver;
    // Media form elements
    private By mediaNameField;
    private By cpm;
    private By mediaSourceRadio;
    private By creativeNameField;
    private By mediaFileTypeUrlRadio;
    private By bitrateField;
    private By widthField;
    private By heightField;
    private By mediaFileUrlField;
    private By createMediaButton;
    private static String mediaFileUrlValue = "http://sftp.rowdy.cc/dilaraTestPage/test15.mp4";

    public pageMediaForm(WebDriver driver) {
        this.driver = driver;
        mediaNameField = By.className("j-media-name");
        cpm = By.className("j-media-cpm");
        mediaSourceRadio = By.id("radio-span_mediaSource__asset");
        creativeNameField = By.className("j-media-uploadName");
        mediaFileTypeUrlRadio = By.id("radio-span_creativeType__mediaUrl");
        bitrateField = By.className("j-media-bitrate");
        widthField = By.className("j-media-width");
        heightField = By.className("j-media-height");
        mediaFileUrlField = By.className("j-media-mediaUrls");
        createMediaButton = By.id("media-save-btn");
    }

    public void createMedia(String name, Integer cpmValue, String creativeName) {
        helpers helper = new helpers();
        helper.pause(4000);
        helper.waitForElement(driver, mediaNameField);
        driver.findElement(mediaNameField).sendKeys(name);
        driver.findElement(cpm).sendKeys(String.valueOf(cpmValue));
        driver.findElement(mediaSourceRadio).click();
        driver.findElement(creativeNameField).sendKeys(creativeName);
        driver.findElement(mediaFileTypeUrlRadio).click();
        driver.findElement(bitrateField).sendKeys("128");
        driver.findElement(widthField).sendKeys("640");
        driver.findElement(heightField).sendKeys("480");
        driver.findElement(mediaFileUrlField).sendKeys(mediaFileUrlValue);
        driver.findElement(createMediaButton).click();
        System.out.print(" Created Media.");
    }
}
