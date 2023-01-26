package com.example.blogapplication.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class GPT {
    public static String token = "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";
    public static Response getBlog(String about){
        RestAssured.baseURI = "https://api.openai.com/v1/completions";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        request.body(requestParams);
        requestParams.put("model", "text-davinci-002");
        requestParams.put("prompt", "Write a blog about "+about);
        requestParams.put("temperature", 1);
        requestParams.put("max_tokens", 4090);
        io.restassured.response.Response response = request.headers(
                        "Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .post()
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        System.out.println(response.then().log().all());
        return response;
    }
}
