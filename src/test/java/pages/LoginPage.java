package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By dashboard = By.xpath("//h6[text()='Dashboard']");

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("dashboard");
    }
}