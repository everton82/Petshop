package Steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.is;

public class Usuario {

    // RestAssured restAssured = new RestAssured();
    RequestSpecification requestSpecification = RestAssured.given();
    //Response response;

    @Dado("^a requisicao contem \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (\\d+)$")
    public void a_requisicao_contem(String Id, String username, String firstname, String lastname, String email, String password, String phone, int userStatus) throws Throwable {

        requestSpecification.given() // Dado que
            .contentType("application/json") // Tipo do conteudo REST é sempre assim
                                            // Existem serviços ASMX e outros, o formato seria text/xml
            .log().all()                   // Gerar um log completo
            // {"id":1

            .body("{\"id\": " + "id" + "," +
                    "\"username\": \" +     username + \"," +
                    "\"firstname\": \" +    firstname + \"," +
                    "\"lastname\": \" +     lastname + \"," +
                    "\"email\": \" +        email + \"," +
                    "\"password\": \" +     password + \", " +
                    "\"phone\": \" +        phone + \"," +
                    "\"userStatus\": +      userStatus + }");

    }

    @Quando("^conecto com a uri da Petshop$")
    public void conecto_com_a_uri_da_Petshop() throws Throwable {
        requestSpecification.when()
            .post("https://petstore.swagger.io/v2/user");
    }

    @Entao("^Valido (\\d+) \"([^\"]*)\" (\\d+)$")
    public void valido(int code, String type, int message) throws Throwable {
        Object resultado = null;
        requestSpecification.then()
            .log().all()
            .statusCode(200)    // Teste de Interoperabilidade -- conectou ---
            .body("code",is(200))
            .body("type",is("unknown"))
            .body("message",is(resultado));
    }
}
