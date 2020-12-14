package api.condition.standard;

import api.condition.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatusCodeCondition implements Condition {

  private final int statusCode;

  @Override
  public void check(ValidatableResponse response) {
    response.assertThat().statusCode(statusCode);
  }

  @Override
  public String toString() {
    return "StatusCodeCondition: " +
      "statusCode is " + statusCode;
  }
}
