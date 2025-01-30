package StroeAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateStatusCode {

    @Test
    public void validateSuccessCode() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification requestspec = RestAssured.given();
        Response response = requestspec.get();
        int statuscode = response.getStatusCode();
        System.out.println("Status code-----> "+statuscode);
        Assert.assertEquals(statuscode,200);
    }

    @Test
    public void validateFailureCode(){
        RestAssured.baseURI = "https://fakestoreapi.com/products/1/test123";
        RequestSpecification requestspec = RestAssured.given();
        Response response = requestspec.get();
        int statuscode = response.getStatusCode();
        System.out.println("Status Code-----> "+statuscode);
        Assert.assertEquals(statuscode,404);
    }

}
