package restAssred;

import io.restassured.http.ContentType;
import org.hamcrest.core.StringContains;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Assertion_02 {
    @Test
    public void test1() {
        given()
                .when()
                .get("https://reqres.in/api/users/1")
                .then()
                .log().body()
                .body("data.id",equalTo(1))
                .body("data.first_name",equalTo("George"))
                .body(containsString("contributions towards"))
                .body("data",hasKey("id"))
                .body("data.id",lessThan(5)) // id 5 ten kucuk olmamali
                .body(not(empty()));

    }
    @Test
    public void test2() {
        given()
                .pathParam("page",2)
                .when()
                .get("https://reqres.in/api/users?page={page}")
                .then()
                .contentType(ContentType.JSON)
                .log().body()
                .statusCode(200)
                .body("page",equalTo(2))                        // page==2 olamli
                .body("data[0].first_name",equalTo("Michael"))  // datanin ilk elemaninin first_name= Michael olmali
                .body("",hasKey("support"))                                     // body nin support isimli key i olmali
                .body(containsString("contributions"))               // body"contributions" icermeli
                .body("data.first_name",hasItems("Michael","Lindsay"))  // data.firsname icinde = Michael ve Lindsay olmali

        ;



    }
}

