package DSLRestassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateBasicAutentication {

    @Test
    public void basicAuthentication(){

        //way1
        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.auth().basic("postman","password");
        Response response = reqSpec.get();
        System.out.println(response.getBody().asPrettyString());
        JsonPath jsonpath = response.jsonPath();
        String autenticateValue = jsonpath.getString("authenticated");
        Assert.assertEquals(autenticateValue,"true");
        Assert.assertEquals(response.statusCode(),200);

        //way2
        RestAssured.given().auth().basic("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", Matchers.equalTo(true));
    }
}
