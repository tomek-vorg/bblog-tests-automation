package api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

public enum ApiClient {

  INSTANCE;

  private final Config config = new Config(ApiClientUtils.supplier());

  public Response execute(ApiRequest request) {
    return RestAssured
      .given()
      .header("authorization", "Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
      .header("authority", "qa-task.backbasecloud.com")
      .spec(request.apply(config.baseReqSpec.get()).build())
      .expect()
      .spec(new ResponseSpecBuilder().build())
      .when()
      .request(request.method(), request.url());
  }

  @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
  private static class Config {
    private final Supplier<RequestSpecBuilder> baseReqSpec;
  }
}
