import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static io.restassured.RestAssured.given;

public class auth {


    public String ObterToken(){

        String user = "{\"email\": \"usuario@email.com\", \"senha\": \"123456\"}";
        String token =
        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .post("http://localhost:8089/api/v1/auth")
                .then().log().all()
                .extract().path("data.token");

        return token;




    }
}
