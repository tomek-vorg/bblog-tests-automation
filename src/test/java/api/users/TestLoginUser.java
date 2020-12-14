package api.users;

import api.executors.users.RegisterUserExecutor;
import api.resources.models.users.PostUsersInput;
import api.resources.models.users.PostUsersLoginBuilder;
import api.resources.models.users.PostUsersLoginInput;
import api.services.bblog.users.post.PostUsersService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static api.condition.Conditions.statusCode;
import static org.apache.http.HttpStatus.SC_OK;

public class TestLoginUser {

  //services
  private final PostUsersService service = new PostUsersService();
  //test data
  private String email;
  private String password;

  @BeforeMethod
  public void preconditions() {
    PostUsersInput response = new RegisterUserExecutor().registerUser();
    email = response.getUser().getEmail().toLowerCase();
    password = response.getUser().getPassword();
  }

  @Test
  public void loginUserHappy() {
    PostUsersLoginInput defaultInputBody = PostUsersLoginBuilder.defaultInput();
    defaultInputBody.getUser().setEmail(email);
    defaultInputBody.getUser().setPassword(password);
    service.executeLogin(defaultInputBody)
      .shouldHave(statusCode(SC_OK));
  }

}
