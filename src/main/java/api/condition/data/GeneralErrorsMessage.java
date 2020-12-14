package api.condition.data;

import lombok.Getter;

public enum GeneralErrorsMessage {

  PASSWORD_MISSING("The \"password\" argument must be one of type string, Buffer, TypedArray, or DataView. Received type object");

  @Getter
  private final String valueContains;

  GeneralErrorsMessage(String errorMessage) {
    this.valueContains = errorMessage;
  }

  public String getMessage() {
    return valueContains;
  }
}
