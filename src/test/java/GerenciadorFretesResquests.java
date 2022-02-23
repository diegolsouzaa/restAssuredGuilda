import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GerenciadorFretesResquests {

    @Test
    public void deveRealizarCadastroComSucesso(){

        Map<String, Object> params = new HashMap<>();
        params.put("localDeEntrega","CB Barueri");
        params.put("quantidade", 3);
        params.put("transportadora", "transDiego");
        params.put("produto","Notebook");

        given()
                .contentType(ContentType.JSON)
                .body(params)
                .when().log().all()
                .post("http://localhost:8089/api/fretes/novo")
                .then().log().all()
                .statusCode(201)
                .body("data.id", notNullValue());
    }

    @Test
    public void naoDeveSerPossivelCadastrarLocalDeEntregaComMenosDeTresLetras(){

        Map<String, Object> params = new HashMap<>();
        params.put("localDeEntrega","AB");
        params.put("quantidade", 5);
        params.put("transportadora", "TransRhuan");
        params.put("produto","Notebook");

        given()
                .contentType(ContentType.JSON)
                .body(params)
                .when().log().all()
                .post("http://localhost:8089/api/fretes/novo")
                .then().log().all()
                .statusCode(400)
                .body("errors[0]", equalTo("Local de Destino deve estar entre 3 e 40 caracteres"));
    }

    @Test
    public void naoDeveSerPossivelCadastrarSemQuantidade(){
        Map<String, Object> params = new HashMap<>();
        params.put("localDeEntrega","CB Barueri");
        params.put("transportadora", "transDiego");
        params.put("produto","Notebook");

        given()
                .contentType(ContentType.JSON)
                .body(params)
                .when().log().all()
                .post("http://localhost:8089/api/fretes/novo")
                .then().log().all()
                .statusCode(400)
                .body("data", nullValue())
                .body("errors[0]", equalTo("quantidade é uma informação obrigatória"));
    }

    @Test
    public void devePesquisarTodosOsFretes(){
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("http://localhost:8089/api/fretes")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void devePesquisarFretePorId(){
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("http://localhost:8089/api/fretes/1")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void deveRetornar404QuandoNaoEncontrarOFrete(){
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("http://localhost:8089/api/fretes/33")
                .then().log().all()
                .body("message", equalTo("Não existe esta viagem cadastrada"))
                .statusCode(404);
    }

    @Test
    public void naoDeveSuportarVerbosDiferentesDePost(){
        Map<String, Object> params = new HashMap<>();
        params.put("localDeEntrega","CB Barueri");
        params.put("dataColeta", "2022-02-01");
        params.put("dataEntrega", "2022-02-01");
        params.put("produto","Notebook");

        given()
                .contentType(ContentType.JSON)
                .body(params)
                .when().log().all()
                .put("http://localhost:8089/api/fretes/novo")
                .then().log().all()
                .statusCode(405);


    }

}
