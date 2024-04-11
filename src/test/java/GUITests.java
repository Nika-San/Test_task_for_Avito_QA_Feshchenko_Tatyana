import cases.GUI;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class GUITests {

    private WebDriver driver;
    private GUI gui;
    private String browserName;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //  System.setProperty("web-driver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
        //  driver = new FirefoxDriver();

        System.setProperty("web-driver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        // Получение имени браузера для добавления к названию скриншота:
        String s = driver.toString();
        String words[] = s.split(" ");
        browserName = words[1];

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.avito.ru/avito-care/eco-impact");
        gui = new GUI(driver);

    }

    @Test
    public void takeScreenBlockBuyAtAvito(Method method) throws IOException, InterruptedException {
        String name = browserName + "_" + method.getName();

        gui.waiter(By.cssSelector(".desktop-video-next-arrow-OO039"));

        int count = 1;
        WebElement locator = driver.findElement(By.cssSelector(".desktop-wrapper-saQEa"));
        gui.takeScreenshot(locator, name, count);
        gui.clickSubmit();

        Thread.sleep(500);

        count++;
        gui.takeScreenshot(locator, name, count);

    }

    @Test
    public void checkClickButtonHowItWorks(Method method) throws IOException, InterruptedException {
        String name = browserName + "_" + method.getName();

        gui.waiter(By.cssSelector(".desktop-video-next-arrow-OO039"));

        int count = 1;
        WebElement locator = driver.findElement(By.cssSelector(".desktop-wrapper-saQEa"));
        gui.takeScreenshot(locator, name, count);
        gui.clickButton();

        gui.waiter(By.cssSelector(".desktop-next-arrow-NKMec"));

        count++;
        locator = driver.findElement(By.cssSelector(".desktop-wrapper-y5YwA"));
        gui.takeScreenshot(locator, name, count);
    }

    @Test
    public void checkClickLoginButton(Method method) throws InterruptedException {
        String name = browserName + "_" + method.getName();

        gui.waiter(By.cssSelector(".desktop-video-next-arrow-OO039"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)", "");

        gui.waiter(By.cssSelector(".desktop-wrapper-OutiE"));

        int count = 1;
        WebElement locator = driver.findElement(By.cssSelector(".desktop-wrapper-OutiE"));
        gui.takeScreenshot(locator, name, count);
        gui.clickButtonLgin();

        Thread.sleep(500);

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        gui.waiter(By.cssSelector(".css-12fgjfr"));

        count++;
        locator = driver.findElement(By.cssSelector(".css-12fgjfr"));
        gui.takeScreenshot(locator, name, count);
    }

    @Test
    public void checkDisplayEcoIconBlock(Method method) throws InterruptedException {
        String name = browserName + "_" + method.getName();

        gui.waiter(By.cssSelector(".desktop-video-next-arrow-OO039"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1400)", "");

        gui.waiter(By.cssSelector(".desktop-wrapper-MjDQF"));

        int count = 1;
        WebElement locator = driver.findElement(By.cssSelector(".desktop-wrapper-MjDQF"));
        gui.takeScreenshot(locator, name, count);
    }

    @Test
    public void checkPopUpsAndClickInSelectProductsInTheseCategoriesBlock(Method method) throws InterruptedException {
        String name = browserName + "_" + method.getName();

        gui.waiter(By.cssSelector(".desktop-video-next-arrow-OO039"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)", "");

        gui.waiter(By.cssSelector(".desktop-wide-ZpwUI"));

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".desktop-item-image-hYw4O"))).perform();

        int count = 1;
        WebElement locator = driver.findElement(By.cssSelector(".desktop-wide-ZpwUI"));
        gui.takeScreenshot(locator, name, count);
        gui.clickImg();

        gui.waiter(By.cssSelector(".desktop-wrapper-w3nD7"));

        count ++;
        locator = driver.findElement(By.cssSelector(".desktop-wrapper-w3nD7"));
        gui.takeScreenshot(locator, name, count);
    }

    @AfterTest
    public void close() {
       driver.close();
    }
}


























