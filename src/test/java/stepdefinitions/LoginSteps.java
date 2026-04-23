package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ExcelUtil;
import org.testng.Assert;

public class LoginSteps {
    LoginPage loginPage;

    @Given("user opens browser")
    public void openBrowser() {
        BaseTest.getDriver().get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user logs in using excel data")
    public void loginWithExcel() throws Exception {
        loginPage = new LoginPage(BaseTest.getDriver());

        ExcelUtil.loadExcel("src/test/resources/testdata/testdata.xlsx", "Sheet1");

        String username = ExcelUtil.getCellData(1, 0);
        String password = ExcelUtil.getCellData(1, 1);
        loginPage.login(username, password);
        ExcelUtil.closeExcel();
    }

    @Then("login should be successful")
    public void verifyLogin() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
    }
}