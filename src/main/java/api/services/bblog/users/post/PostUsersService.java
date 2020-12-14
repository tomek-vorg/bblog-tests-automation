package api.services.bblog.users.post;

import api.assertions.AssertableResponse;
import api.services.ApiClient;

public class PostUsersService {

  public AssertableResponse executeRegister(Object body) {
    return new AssertableResponse(
      ApiClient.INSTANCE
        .execute(new PostUsersApiRequest(body))
        .then());
  }

  public AssertableResponse executeLogin(Object body) {
    return new AssertableResponse(
      ApiClient.INSTANCE
        .execute(new PostUsersLoginApiRequest(body))
        .then());
  }
}
