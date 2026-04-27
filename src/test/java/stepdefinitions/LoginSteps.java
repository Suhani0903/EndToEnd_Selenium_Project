package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ExcelUtil;
import org.testng.Assert;
import pages.EmployeePage;

public class LoginSteps {
    LoginPage loginPage;
    EmployeePage employeePage;

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

    @When("user navigates to PIM module")
    public void navigateToPIM() {
        employeePage = new EmployeePage(BaseTest.getDriver());
        employeePage.navigateToPIM();
    }

    @When("user adds a new employee")
    public void addEmployee() {
        String uniqueName = "Sakshi" + System.currentTimeMillis();
        employeePage.addEmployee(uniqueName, "Patel");
    }

    @Then("employee should be added successfully")
    public void verifyEmployeeAdded() {
        Assert.assertTrue(employeePage.isEmployeeAdded(), "Employee not added!");
    }
}