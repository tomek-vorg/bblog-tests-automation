package api.executors.users;

import api.resources.models.users.PostUsersBuilder;
import api.resources.models.users.PostUsersInput;
import api.resources.models.users.PostUsersOutput;
import api.services.bblog.users.post.PostUsersService;

import static api.condition.Conditions.statusCode;
import static org.apache.http.HttpStatus.SC_OK;

public class RegisterUserExecutor {

  private final PostUsersService service = new PostUsersService();

  public PostUsersInput registerUser() {
    PostUsersInput defaultInputBody = PostUsersBuilder.defaultInput();
    service.executeRegister(defaultInputBody)
      .shouldHave(statusCode(SC_OK))
      .extractResponseAs(PostUsersOutput.class);

    return defaultInputBody;
  }

}
