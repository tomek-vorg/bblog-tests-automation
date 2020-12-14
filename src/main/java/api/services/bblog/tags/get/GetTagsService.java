package api.services.bblog.tags.get;

import api.assertions.AssertableResponse;
import api.services.ApiClient;

public class GetTagsService {

  public AssertableResponse execute() {
    return new AssertableResponse(
      ApiClient.INSTANCE
        .execute(new GetTagsApiRequest())
        .then());
  }
}
