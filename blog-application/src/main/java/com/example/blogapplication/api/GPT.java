package com.example.blogapplication.api;

import com.example.blogapplication.models.RequestBody;
import com.example.blogapplication.models.TrendsResponse;
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
        Response response =  given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer "+token)
                .body(new RequestBody("text-davinci-002","Write a blog about "+about,1,4090))
                .post();
        System.out.println(response.then().log().all());
        return response;
    }
    public static TrendsResponse trends() {

        RestAssured.baseURI = "https://trends.google.com/trends/api/dailytrends?hl=en-US&tz=-240&geo=US&ns=15";
        Response response = given()
                .header("Content-Type", "application/json")
                .get();
        System.out.println(response.then().log().all());
        return response.as(TrendsResponse.class);
    }
}
