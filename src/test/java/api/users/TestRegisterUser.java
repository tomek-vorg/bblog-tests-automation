package api.users;

import api.resources.models.users.PostUsersBuilder;
import api.resources.models.users.PostUsersInput;
import api.resources.models.users.PostUsersOutput;
import api.services.bblog.users.post.PostUsersService;
import org.testng.annotations.Test;

import static api.condition.Conditions.errorMessage;
import static api.condition.Conditions.statusCode;
import static api.condition.data.GeneralErrorsMessage.PASSWORD_MISSING;
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.apache.http.HttpStatus.SC_OK;

public class TestRegisterUser {

  private final PostUsersService service = new PostUsersService();

  @Test
  public void registerUserHappy() {
    PostUsersInput defaultInputBody = PostUsersBuilder.defaultInput();
    String token = service.executeRegister(defaultInputBody)
      .shouldHave(statusCode(SC_OK))
      .extractResponseAs(PostUsersOutput.class)
      .getUser().getToken();

    System.out.println(token);
  }

  @Test
  public void registerUserMissingPassword() {
    PostUsersInput defaultInputBody = PostUsersBuilder.defaultInput();
    defaultInputBody.getUser().setPassword(null);
    service.executeRegister(defaultInputBody)
      .shouldHave(statusCode(SC_INTERNAL_SERVER_ERROR))
      .shouldHave(errorMessage(PASSWORD_MISSING));
  }
}
