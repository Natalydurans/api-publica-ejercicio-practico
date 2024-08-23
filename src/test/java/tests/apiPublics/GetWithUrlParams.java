package tests.apiPublics;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetWithUrlParams {

    //@Test
    public void getWithUrlParams(){
        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id", "1")
                .formParam("id", "2");


        Response response = requestSpecification
                .when()
                .get();
        response.prettyPrint();
    }

    @Test
    public void getWithUrlParamsSingleLine(){
        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id", 1,2);

        Response response = requestSpecification
                .when()
                .get();
        response.prettyPrint();

    }
}
