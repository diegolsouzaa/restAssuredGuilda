import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class RestAssureTestOne {


    @Test
    public void testeUm(){

        Map<String, Object> params = new HashMap<>();
        params.put("localDeEntrega","CB Barueri");
        params.put("dataColeta", "2022-02-01");
        params.put("dataEntrega", "2022-02-01");
        params.put("produto","Recife");

        given()
                .contentType(ContentType.JSON)
                //.body("{\"localDeEntrega\" : \"Nefff\", \"dataColeta\" : \"2021-08-01\", \"dataEntrega\": \"2021-09-01\", \"produto\":\"Recife\"}")
                .body(params)
                .when().log().all()
                .post("http://localhost:8089/api/fretes/novo")
                .then().log().all()
                .statusCode(201);
    }
}
