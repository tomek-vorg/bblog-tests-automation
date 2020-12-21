package ui.models.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects {

  @FindBy(xpath = "/html/body/app-root/app-register/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input")
  protected WebElement usernameInputField;

  @FindBy(xpath = "/html/body/app-root/app-register/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input")
  protected WebElement emailInputField;

  @FindBy(xpath = "/html/body/app-root/app-register/div/div/div/div/app-dynamic-form/form/app-input[3]/fieldset/input")
  protected WebElement passwordInputField;

  @FindBy(xpath = "/html/body/app-root/app-register/div/div/div/div/button")
  protected WebElement signUpButton;

  public RegisterPageObjects(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void setUsername(String username) {
    usernameInputField.sendKeys(username);
  }

  public void setEmail(String email) {
    emailInputField.sendKeys(email);
  }

  public void setPassword(String password) {
    passwordInputField.sendKeys(password);
  }

  public void clickSignUp() {
    signUpButton.click();
  }
}
