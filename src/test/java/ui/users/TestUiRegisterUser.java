package ui.users;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.home.HomePageObjects;
import ui.models.home.RegisterPageObjects;

public class TestUiRegisterUser {

  private final WebDriver driver = new ChromeDriver();
  private final HomePageObjects mainPage = new HomePageObjects(driver);
  private final RegisterPageObjects registerPage = new RegisterPageObjects(driver);

  @BeforeClass
  public void preconditions() {
    System.setProperty("webdriver.chrome.driver", "C:\\utils\\chromedriver.exe");
    driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
    driver.manage().window().maximize();
  }

  @SneakyThrows
  @Test
  public void registerUser() {
    String emailBuilder = RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphanumeric(4) + ".pl";
    mainPage.clickOnSignUpLink();
    registerPage.setUsername((RandomStringUtils.randomAlphanumeric(10)));
    registerPage.setEmail(emailBuilder);
    registerPage.setPassword((RandomStringUtils.randomAlphanumeric(6)));
    Thread.sleep(1000);
    registerPage.clickSignUp();
  }
}
