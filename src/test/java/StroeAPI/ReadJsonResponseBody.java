package StroeAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadJsonResponseBody {

    @Test
    public void readJSONResponse(){
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void readJSONResponseasStringValidate(){
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"));
    }


    @Test
    public void readJSONResponseValidatedata(){

        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        JsonPath jsonpath = response.jsonPath();
        System.out.println(jsonpath);
        String actualPrice = jsonpath.getString("price");
        String actulCategory = jsonpath.getString("category");
        System.out.println(actualPrice);
        System.out.println(actulCategory);
        Assert.assertEquals(actualPrice,"109.95");
        Assert.assertEquals(actulCategory,"men's clothing");
    }

}
