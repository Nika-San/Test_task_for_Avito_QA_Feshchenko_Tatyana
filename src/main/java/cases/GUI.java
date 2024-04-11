package cases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GUI {
    static WebDriver driver;

    public GUI(WebDriver driver) {
        this.driver = driver;
    }

    private final By SUBMIT = By.cssSelector(".desktop-video-next-arrow-OO039");
    private final By BUTTON = By.cssSelector(".desktop-button-wrapper-UMUX3");
    private final By BUTTON_LOGIN = By.cssSelector(".desktop-button-wrapper-K8ki0");
    private final By IMG = By.cssSelector(".desktop-item-image-hYw4O");

    public void clickSubmit() {driver.findElement(SUBMIT).click();}
    public void clickButton() {driver.findElement(BUTTON).click();}
    public void clickButtonLgin() {driver.findElement(BUTTON_LOGIN).click();}
    public void clickImg() {driver.findElement(IMG).click();}


    public void takeScreenshot(WebElement webEl, String testName, int stepName) throws InterruptedException {
        String fileName = testName + "_" + stepName;

        Thread.sleep(5000);

        File uiElementSrc = webEl.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(uiElementSrc, new File("src\\main\\resources\\output\\" + fileName + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void waiter(By webEl){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webEl));

    }
}