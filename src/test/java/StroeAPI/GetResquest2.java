package StroeAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetResquest2 {

    public static void main(String[] args) {


        RestAssured.baseURI="https://fakestoreapi.com/products";
        RequestSpecification requestspec = RestAssured.given();
        Response response = requestspec.get();
        System.out.println(response.prettyPrint());

    }
}
