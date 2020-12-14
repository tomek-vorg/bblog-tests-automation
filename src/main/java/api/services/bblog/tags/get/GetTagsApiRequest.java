package api.services.bblog.tags.get;

import api.services.ApiRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import lombok.RequiredArgsConstructor;

import static api.services.data.BaseData.QA_URL;

@RequiredArgsConstructor
public class GetTagsApiRequest implements ApiRequest {

  @Override
  public String url() {
    return QA_URL  + "tags";
  }

  @Override
  public Method method() {
    return Method.GET;
  }

  public RequestSpecBuilder apply(RequestSpecBuilder requestSpecBuilder) {
    return requestSpecBuilder;
  }
}
