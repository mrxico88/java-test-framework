package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Authentication{

    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public Authentication(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        seleniumUtils = new SeleniumUtils(driver);
    }
    @FindBy(id="email_create")
    private WebElement createNewUserEmailInput;

    @FindBy(id="SubmitCreate")
    private WebElement createNewUserSubmitButton;

    @FindBy(id="email")
    private WebElement inputEmailLogin;

    @FindBy(id="passwd")
    private WebElement inputPasswordLogin;

    @FindBy(id="SubmitLogin")
    private WebElement loginButton;

    public void inputEmailToCreateNewUser(String email){
        createNewUserEmailInput.sendKeys(email);
    }

    public CreateAccount clickCreateUserSubmitButton(){
        createNewUserSubmitButton.click();
        return new CreateAccount(driver);
    }

    public MyAccount loginAsExistingUser(String username, String password){
        inputEmailLogin.sendKeys(username);
        inputPasswordLogin.sendKeys(password);
        seleniumUtils.clickElement(loginButton);
        return new MyAccount(driver);
    }



}
