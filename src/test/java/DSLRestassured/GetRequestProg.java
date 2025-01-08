package DSLRestassured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class GetRequestProg {

    public static void main(String[] args) {

        //RestAssured.baseURI = "https://fakestoreapi.com/products";

      RestAssured.given()
              .when()
              .get("https://fakestoreapi.com/products")
              .then()
              .log().all();

    }
}
