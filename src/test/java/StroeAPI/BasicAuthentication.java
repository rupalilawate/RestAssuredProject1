package StroeAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthentication {


    @Test
    public void basicAuthentication(){

        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RequestSpecification reqspec = RestAssured.given();
        reqspec.auth().basic("postman","password");
        Response response = reqspec.get();
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getStatusCode());

        JsonPath jsonpath = response.jsonPath();
        String authenticated = jsonpath.getString("authenticated");
        int statcode = response.getStatusCode();
        Assert.assertEquals(authenticated,"true");
        Assert.assertEquals(statcode,200);

    }
}
