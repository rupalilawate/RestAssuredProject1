package StroeAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PreemptiveAuthentication {


    @Test
    public void preemptiveAuthentication(){

        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RequestSpecification reqspec = RestAssured.given();
        reqspec.auth().preemptive().basic("postman","password");
        Response response = reqspec.get();
        System.out.println(response.getBody().asPrettyString());
        JsonPath jsonpath = response.jsonPath();
        String authenticated = jsonpath.getString("authenticated");
        Assert.assertEquals(authenticated,"true");
        Assert.assertEquals(response.getStatusCode(),200);
    }


}
