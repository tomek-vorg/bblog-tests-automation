package api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;

public interface ApiRequest {

  String url();

  Method method();

  RequestSpecBuilder apply(RequestSpecBuilder requestSpecBuilder);
}
