package tests.apiPublics;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdateObject {

    @Test
    public void updateObject(){
        File putBody = new File("src/main/resources/putObject.json");

        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(putBody);

        Response response = requestSpecification
                .when()
                .put("/ff80818190910e080190952ed3e20ad9");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
