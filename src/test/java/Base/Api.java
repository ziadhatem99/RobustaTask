package Base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Api {
    private String firstName;
    private String lastName;
    private String zipCode;
    public void getData(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        int userId = 1;
        Response response = RestAssured
                .given()
                .when().log().all()
                .get("/users/" + userId)
                .then().log().all()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");
        String[] nameParts = name.split(" ");
        this.firstName = nameParts[0];
        this.lastName = nameParts.length > 1 ? nameParts[1] : "";
        this.zipCode = jsonPath.getString("address.zipcode");
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
