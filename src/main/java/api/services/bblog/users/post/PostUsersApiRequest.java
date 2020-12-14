package api.services.bblog.users.post;

import api.services.ApiRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import lombok.RequiredArgsConstructor;

import static api.services.data.BaseData.QA_URL;

@RequiredArgsConstructor
public class PostUsersApiRequest implements ApiRequest {

  private final Object body;

  @Override
  public String url() {
    return QA_URL + "users";
  }

  @Override
  public Method method() {
    return Method.POST;
  }

  public RequestSpecBuilder apply(RequestSpecBuilder requestSpecBuilder) {
    return requestSpecBuilder
      .setBody(body);
  }
}
