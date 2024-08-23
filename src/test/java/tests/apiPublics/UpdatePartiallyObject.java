package tests.apiPublics;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdatePartiallyObject {

    @Test
    public void updatePartiallyObject(){
        File patchBody = new File("src/main/resources/patchObject.json");

        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(patchBody);

        Response response = requestSpecification
                .when()
                .patch("/ff80818190910e080190952ed3e20ad9");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
