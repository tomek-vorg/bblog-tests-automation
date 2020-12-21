package ui.models.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

  @FindBy(xpath = "//a[@href='#/']")
  protected WebElement homeLink;

  @FindBy(xpath = "//a[@href='#/login']")
  protected WebElement signInLink;

  @FindBy(xpath = "//a[@href='#/register']")
  protected WebElement signUpLink;

  public HomePageObjects(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void clickOnHomeLink() {
    homeLink.click();
  }

  public void clickOnSingInLink() {
    signInLink.click();
  }

  public void clickOnSignUpLink() {
    signUpLink.click();
  }
}
