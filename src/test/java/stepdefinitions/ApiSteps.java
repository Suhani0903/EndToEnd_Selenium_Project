package stepdefinitions;

import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiSteps {

    @Then("user validates API response")
    public void validateAPI() {

        given()
                .header("Accept", "application/json")
                .when()
                .get("https://jsonplaceholder.typicode.com/users/2")
                .then()
                .statusCode(200)
                .body("id", equalTo(2));
    }
}