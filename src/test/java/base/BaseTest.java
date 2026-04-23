package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BaseTest {

    private static WebDriver driver;
    private static final boolean USE_GRID = true;

    public static void initDriver() {
        try {
            if (driver == null) {
                if (USE_GRID) {
                    ChromeOptions options = new ChromeOptions();
                    driver = new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            options
                    );
                } else {
                    driver = new ChromeDriver();
                }
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}