package api.condition.error;

import api.assertions.errors.GeneralErrorOutput;
import api.condition.Condition;
import api.condition.data.GeneralErrorsMessage;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.core.StringContains;

import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
public class ErrorMessageCondition implements Condition {

  private final GeneralErrorsMessage errorMessage;

  @Override
  public void check(ValidatableResponse response) {
    String message = response
      .extract()
      .response()
      .body()
      .as(GeneralErrorOutput.class)
      .getErrors().getMessage();

    assertThat(message, StringContains.containsString(errorMessage.getMessage()));
  }
}
