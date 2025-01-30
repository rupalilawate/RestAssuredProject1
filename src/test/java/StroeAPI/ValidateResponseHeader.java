package StroeAPI;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateResponseHeader {

    @Test
    public void printAllHeaders(){
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification requestspec = RestAssured.given();
        Response response = requestspec.get();
        Headers headers = response.headers();
        for(Header header1:headers){
            System.out.println(header1);
        }

    }

    @Test
    public void getSpecificHeader(){


    }

    @Test
    public void validateHeader(){


    }

}
