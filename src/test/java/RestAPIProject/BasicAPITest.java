package RestAPIProject;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicAPITest {

    public static void main(String[] args) {
        // Validate if Add place API is working as expected

        // given  - All input details
        //When -  Submit the API there
        // Then- Validate the response

        baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key"," qaclick123").header("Content-Type", "application/json")
                .body("Copy the body  ").when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("app"));

        // Add place - Update place with the new address and -> Get place to validate if the New Address is present


    }
}
