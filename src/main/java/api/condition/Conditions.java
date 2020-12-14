package api.condition;

import api.condition.data.GeneralErrorsMessage;
import api.condition.error.ErrorMessageCondition;
import api.condition.standard.ResponseBodyCondition;
import api.condition.standard.StatusCodeCondition;
import org.hamcrest.Matcher;

public class Conditions {

  public static StatusCodeCondition statusCode(int code) {
    return new StatusCodeCondition(code);
  }

  public static ResponseBodyCondition jsonObject(String jsonPath, Matcher matcher) {
    return new ResponseBodyCondition(matcher, jsonPath);
  }

  public static ErrorMessageCondition errorMessage(GeneralErrorsMessage errorMessage) {
    return new ErrorMessageCondition(errorMessage);
  }
}
