package com.pp.controller;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONArray;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class WebServiceControllerTest {

    @org.testng.annotations.Test
    public void testGetAllRecords() {
    Response response = given()
                            .contentType(ContentType.JSON)
                            .when()
                            .request(Method.GET,"http://localhost:8080/model/getAll")
                            .then()
                            .extract()
                            .response();

    JSONArray jsonArray = new JSONArray(response.asString());

    JSONObject indexOne = (JSONObject) jsonArray.get(1);
    JSONObject indexTwo = (JSONObject) jsonArray.get(2);

    assertThat(indexOne.get("uid"),is(11));
    assertThat(indexTwo.get("uid"),is(12));
    }

    @org.testng.annotations.Test
    public void testGetRecordById() {

        Response response =given()
                                .contentType(ContentType.JSON)
                                .when()
                                .request(Method.GET,"http://localhost:8080/model/get/12")
                                .then()
                                .extract()
                                .response();

        JSONObject jsonObject = new JSONObject(response.asString());

        int statusCode = response.statusCode();
        String name = jsonObject.getString("uname");

        assertThat(statusCode,is(200));
        assertThat(name , containsString("raja"));
    }

    @org.testng.annotations.Test
    public void testSaveRecord() {
        String data = "{\n" +
                "  \"umail\": \"raja\",\n" +
                "  \"uname\": \"raja\",\n" +
                "  \"upassword\": \"raja\"\n" +
                "}";

        Response response = given()
                                .body(data)
                                .contentType(ContentType.JSON)
                                .when()
                                .request(Method.POST,"http://localhost:8080/model/save")
                                .then()
                                .extract()
                                .response();

        JSONObject jsonObject = new JSONObject(response.asString());

        int statusCode =response.getStatusCode();
        String name = jsonObject.getString("uname");

        assertThat(name,containsString("raja"));
        assertThat(response.getStatusCode(),is(200));
    }

    @org.testng.annotations.Test
    public void testUpdateRecord() {

        String data = "{\n" +
                "  \"uid\": 14,\n" +
                "  \"uname\": \"mohit1\",\n" +
                "  \"umail\": \"mohit@gmail.com\",\n" +
                "  \"upassword\": \"mohit1234\"\n" +
                "}";

        Response response = given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .request(Method.PUT,"http://localhost:8080/model/update/11")
                .then()
                .extract()
                .response();

        JSONObject jsonObject = new JSONObject(response.asString());

        int statusCode =response.getStatusCode();
        String name = jsonObject.getString("uname");

        assertThat(name,containsString("mohit1"));
        assertThat(response.getStatusCode(),is(200));
    }

    @org.testng.annotations.Test
    public void testDeleteRecordById() {

        Response response =given()
                .contentType(ContentType.JSON)
                .when()
                .request(Method.DELETE,"http://localhost:8080/model/delete/13")
                .then()
                .extract()
                .response();

        JSONObject jsonObject = new JSONObject(response.asString());

        int statusCode = response.statusCode();

        assertThat(statusCode,is(200));
    }
}