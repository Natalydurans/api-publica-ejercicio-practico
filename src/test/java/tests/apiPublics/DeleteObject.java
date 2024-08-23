package tests.apiPublics;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteObject {

    @Test
    public void deleteObject(){
        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");

        Response response = requestSpecification
                .when()
                .delete("/ff80818190910e080190952ed3e20ad9");

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}
