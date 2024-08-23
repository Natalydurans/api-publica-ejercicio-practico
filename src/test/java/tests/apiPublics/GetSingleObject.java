package tests.apiPublics;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObject {

    @Parameters({"id", "expectedStatusCode"})
    @Test
    public void getSingleObject(String id, int expectedStatusCode){
        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");

        Response response = requestSpecification
                .when()
                .get(id);

        response.prettyPrint();

        int serviceStatusCode = response.getStatusCode();
        Assert.assertEquals(serviceStatusCode, expectedStatusCode);

        /*JSONObject jsonResponse = new JSONObject(response.asString());
        String name = jsonResponse.getString("name");
        System.out.println(name);

        JSONObject jsonData = jsonResponse.getJSONObject("data");
        String cpuModel = jsonData.getString("CPU model");
        System.out.println(cpuModel);*/

    }
}
