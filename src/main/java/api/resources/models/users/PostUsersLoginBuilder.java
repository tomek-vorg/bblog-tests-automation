package api.resources.models.users;

import org.apache.commons.lang3.RandomStringUtils;

public class PostUsersLoginBuilder {

  public static PostUsersLoginInput defaultInput() {
    String emailBuilder = RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphanumeric(4) + ".pl";
    return PostUsersLoginInput.builder()
      .user(User.builder()
        .email(emailBuilder)
        .password("")
        .build())
      .build();
  }
}
