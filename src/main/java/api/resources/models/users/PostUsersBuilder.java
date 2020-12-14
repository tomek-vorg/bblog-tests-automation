package api.resources.models.users;

import org.apache.commons.lang3.RandomStringUtils;

public class PostUsersBuilder {

  public static PostUsersInput defaultInput() {
    String emailBuilder = RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphanumeric(4) + ".pl";
    return PostUsersInput.builder()
      .user(User.builder()
        .email(emailBuilder)
        .password(RandomStringUtils.randomAlphanumeric(6))
        .username(RandomStringUtils.randomAlphanumeric(10))
        .build())
      .build();
  }
}
