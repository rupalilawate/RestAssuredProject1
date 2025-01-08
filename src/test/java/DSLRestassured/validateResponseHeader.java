package DSLRestassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateResponseHeader {

    @Test
    public void printAllHeaders(){
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        Headers headers = response.headers();
        for(Header header:headers){
            System.out.println(header);
        }

        //way2
        RestAssured.given()
                .when()
                .get("https://fakestoreapi.com/products/1")
                .then()
                .log().headers();
    }

    @Test
    public void getSpecificHeader(){
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.getHeader("Server"));
        System.out.println(response.getHeader("x-powered-by"));

        //way2
        String header = RestAssured.given()
                .when().get("https://fakestoreapi.com/products/1")
                .getHeader("Server");
        System.out.println(header);
    }

    @Test
    public void validateResponseHeader(){
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification resqustsep = RestAssured.given();
        Response response = resqustsep.get();
        String contenttype = response.getHeader("Content-Type");
        String server = response.getHeader("Server");
        String xpoweredby = response.getHeader("x-powered-by");
        Assert.assertEquals(contenttype,"application/json; charset=utf-8");
        Assert.assertEquals(server,"cloudflare");
        Assert.assertEquals(xpoweredby,"Express");


        //way2
        RestAssured.given()
                .when().get("https://fakestoreapi.com/products/1")
                .then().header("Content-Type","application/json; charset=utf-8")
                .header("Server","cloudflare")
                .header("x-powered-by","Express");


    }





}
