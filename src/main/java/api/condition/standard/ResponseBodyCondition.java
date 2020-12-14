package api.condition.standard;

import api.condition.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class ResponseBodyCondition implements Condition {

  private final Matcher matcher;
  private final String jsonPath;

  @Override
  public void check(ValidatableResponse response) {
    response.assertThat().body(jsonPath, matcher);
  }
}
