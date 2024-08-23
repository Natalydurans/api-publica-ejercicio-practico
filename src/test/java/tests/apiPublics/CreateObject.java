package tests.apiPublics;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class CreateObject {
    String path = "./Reporte/Apis.html";
    ExtentReports extent = new ExtentReports();
    ExtentTest test;
    ExtentSparkReporter spark = new ExtentSparkReporter(path);





    @Test
    public void createObject() {
        extent.attachReporter(spark);
        test = extent.createTest("Prueba");
        File postBody = new File("src/main/resources/createObject.json");
        test.log(Status.INFO, "Paso la ruta del archivo del body que es: " + postBody);
        RequestSpecification requestSpecification = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type", "application/json")
                .body(postBody);

        Response response = requestSpecification
                .when()
                .post();

        test.log(Status.INFO, "Realizo el consumo del api");
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        test.log(Status.INFO, "El status code es: " + statusCode);
        Assert.assertEquals(statusCode, 200);

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test fallido");
        } else {
            test.log(Status.PASS, "Test exitoso");
        }
        extent.flush();
    }
}
