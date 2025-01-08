package DSLRestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateStatusCode {

    @Test
    public void validateSuccessCode(){
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);

        //way2
        RestAssured.given()
                .when()
                .get("https://fakestoreapi.com/products/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void validateFailureResponseCode(){
        RestAssured.given()
                .when()
                .get("https://fakestoreapi.com/products/1/test")
                .then()
                .statusCode(404);
    }


}
