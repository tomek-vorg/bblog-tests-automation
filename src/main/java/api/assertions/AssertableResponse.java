package api.assertions;

import api.condition.Condition;
import io.restassured.http.Headers;
import io.restassured.response.ValidatableResponse;

import java.lang.reflect.Type;

public class AssertableResponse {

  private final ValidatableResponse response;

  public AssertableResponse(ValidatableResponse response) {
    this.response = response;
  }

  public AssertableResponse shouldHave(Condition condition) {
    condition.check(response);
    return this;
  }

  public String extractObject(String jsonPath) {
    return response
      .extract()
      .jsonPath()
      .getJsonObject(jsonPath);
  }

  public <T> T extractResponseAs(Class<T> tClass) {
    return response
      .extract()
      .as(tClass);
  }

  public <T> T extractResponseAsType(Type type) {
    return response
      .extract()
      .as(type);
  }

  public String responseAsString() {
    return response.extract()
      .response()
      .body()
      .asString();
  }

  public Headers getHeaders() {
    return response.extract()
      .response()
      .getHeaders();}

  public String getCookie() {
    return response.extract()
      .response()
      .getHeader("Set-Cookie");
  }

  public AssertableResponse andResponse() {
    return this;
  }
}
