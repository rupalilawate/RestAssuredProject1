package DSLRestassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateJSONResponse {

    @Test
    public void readJsonResponse(){
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification requSpec = RestAssured.given();
        Response response = requSpec.get();
        String jsonBody = response.getBody().asString();
        System.out.println(jsonBody);

        //way2
        RestAssured.given()
                .when().get("https://fakestoreapi.com/products/1")
                .then().log().body();
    }

    @Test
    public void validateJSONResponse()
    {
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqspec =  RestAssured.given();
        Response response = reqspec.get();
        String reponseBody = response.getBody().asString();
        Assert.assertTrue(reponseBody.contains("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"));

    }

    @Test
    public void validateResponseDataByJsonPath(){
        //way1
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();
        JsonPath jsonpath = response.jsonPath();
        String titileValue = jsonpath.getString("title");
        String countValue = jsonpath.getString("rating.count");
        System.out.println("title:" + titileValue);
        System.out.println("count:" + countValue);
        Assert.assertEquals(titileValue,"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        Assert.assertEquals(countValue,"120");

        //way2
        RestAssured.given()
                .when().get("https://fakestoreapi.com/products/1")
                .then()
                .body("title", Matchers.equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"))
                .body("rating.count", Matchers.equalTo(120));

    }
}
