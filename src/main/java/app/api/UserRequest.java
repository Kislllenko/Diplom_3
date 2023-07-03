package app.api;

import app.url.Uri;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserRequest {

    @Step("POST запрос для создания пользователя")
    public static Response create(Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when().post(Uri.CREATE);
    }

    @Step("POST запрос для логина пользователя")
    public static Response login(Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when().post(Uri.LOGIN);
    }

    @Step("DELETE запрос для удаления пользователя")
    public static void delete(String userAccessToken) {
        given()
                .header("Authorization", userAccessToken)
                .when()
                .delete(String.format(Uri.DELETE));
    }

}
