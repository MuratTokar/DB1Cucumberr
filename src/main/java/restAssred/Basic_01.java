package restAssred;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;


public class Basic_01 {

    // Rest assured ile backend testi yapariz
    //BDD mantigindan yazilir . yani kosul sonuc cucumber features gibi
    // Given() ön kosul , yani Request kismini ifade eder.
    //When() method(GET, POST,PUT...) gibi kisimlari ifade eder
    // Then () assertionlari ifade eder.     Yani responce yi iafde eder.Request teki tests kismi buraya yazilir

    @Test
    public void test1() {
        given()
                .when()
                .then();

    }

    @Test
    public void test2_GetMethod() {
        given()
                // .log().headers()// burda request in headers i yazdiracak
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()// buranin altindaki log ile response degereleri yazar.Request in de test kismi buraya yazilir
                // .log().body() // log ile istenilen kisim (yani body)consola yazdirilir
                // .log().all();// herseyi yazdik
                .log().headers();// headers i yadirdik

    }

    @Test
    public void test3_StatusCode() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .log().status()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }


    @Test
    public void test4_ResponseTime() {
        String url = "https://reqres.in/api/users?page=1";
        given().
                when().
                get(url).
                then()
                .statusCode(200);


        long time = given().
                get(url)
                .timeIn(TimeUnit.MILLISECONDS);
        System.out.println(time);


    }

    @Test
    public void test5_PrettyPrint() {

        String url = "https://reqres.in/api/users?page=1";

        Response response = given().
                get(url).
                then().
                extract().// istenilen data yi ayirmak icin kullanilir
                        response();//response exract edildi
        response.prettyPrint(); // response pretty  print yapti
        response
                .then()
                .statusCode(200);

    }

    @Test
    public void test6_PathParam() {
        given().
                pathParam("page", "1").
                pathParam("link", "api").
                when().
                get("https://reqres.in/{link}/users?page={page}").
                then().
                statusCode(200)
                .log().status();
    }

    @Test
    public void test7_getSingleUser() {
        for (int i = 1; i < 6; i++) {


            given().
                    pathParams("page", i).
                    when().
                    get("https://reqres.in/api/users/{page}").
                    then()
                    .log().body();

        }

    }

    @Test
    public void test8_baseUri() {
        RestAssured.baseURI = "https://reqres.in";// asagidaki adreste https yoksa burdan alir
        given()
                .when()
                .get("/api/users?page=1")
                .then()
                .log().body();

        given().when().
                get("https://reqres.in/api/users?page=2").
                then().
                log().body();

    }

    @Test
    public void test8_basePath() {
        RestAssured.baseURI = "https://reqres.in";// asagidaki adreste https yoksa burdan alir
        RestAssured.basePath = "/api";
        given()
                .when()
                .get("/users?page=1")
                .then()
                .log().body();

    }
}