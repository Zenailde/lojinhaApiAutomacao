package modulos.produto;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Teste de Api rest do módulo de produto")
public class ProdutoTest {
    @Test
    @DisplayName("Validar os limites proibidos do valor do produto")
    public void testValidarLimitesProibidoValorProduto(){

       //configurando os dados da api rest da lojinha
        baseURI = "165.227.93.41";
        basePath = "/lojinha";
        // obter o token do usuário admin

        String token = given().contentType(ContentType.JSON)
                    .body("{\n" +
                      "  \"usuarioLogin\": \"admin\",\n" +
                     "  \"usuarioSenha\": \"admin\"\n" +
                     "}")
                .when()
                    .post("/v2/login")
                .then()
                    .extract()
                        .path("data.token");

    //validando valores limites

        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body("{\n" +
                        "  \"produtoNome\": \"string\",\n" +
                        "  \"produtoValor\": 0,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"string\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"string\",\n" +
                        "      \"componenteQuantidade\": 0\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")

    }

}
