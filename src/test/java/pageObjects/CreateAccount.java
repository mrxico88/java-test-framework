package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class CreateAccount {

    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    public CreateAccount(WebDriver remoteDriver){
        driver = remoteDriver;
        seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#id_gender2")
    private WebElement checkboxGenderFemale;

    @FindBy(css="#id_gender1")
    private WebElement checkboxGenderMale;

    @FindBy(id="customer_firstname")
    private WebElement inputCustomerFirstName;

    @FindBy(id="customer_lastname")
    private WebElement inputCustomerLastName;

    @FindBy(id="email")
    private WebElement inputEmail;

    @FindBy(id="passwd")
    private WebElement inputPassword;

    @FindBy(id="days")
    private WebElement dropdownMenuDays;

    @FindBy(css="#days > option:nth-child(3)")
    private WebElement selectedDay;

    @FindBy(id="months")
    private WebElement dropdownMenuMonths;

    @FindBy(css="#months > option:nth-child(2)")
    private WebElement selectedMonth;

    @FindBy(id="years")
    private WebElement dropdownMenuYear;

    @FindBy(css="#years > option:nth-child(20)")
    private WebElement selectedYear;

    @FindBy(id="firstname")
    private WebElement inputAddressFirstName;

    @FindBy(id="lastname")
    private WebElement inputAddressLastName;

    @FindBy(id="company")
    private WebElement inputAddressCompany;

    @FindBy(id="address1")
    private WebElement inputAddress1;

    @FindBy(id="address2")
    private WebElement inputAddress2;

    @FindBy(id="city")
    private WebElement inputAddressCity;

    @FindBy(id="id_state")
    private WebElement dropdownMenuState;

    @FindBy(css="#id_state > option:nth-child(3) ")
    private WebElement selectedState;

    @FindBy(id="postcode")
    private WebElement inputAddressPostCode;

    @FindBy(id="id_country")
    private WebElement dropdownMenuCountry;

    @FindBy(css="#id_country > option:nth-child(2) ")
    private WebElement selectedCountry;

    @FindBy(id="other")
    private WebElement inputAddressAdditionalInformation;

    @FindBy(id="phone")
    private WebElement inputAddressPhone;

    @FindBy(id="alias")
    private WebElement inputAddressAlias;

    @FindBy(id="submitAccount")
    private WebElement submitAccountBtn;

    public MyAccount addUserInfo(String password) throws InterruptedException{
        //seleniumUtils.waitForElementToBeVisble(checkboxGenderMale, 5);
        Thread.sleep(3000);
        checkboxGenderMale.click();
        inputCustomerFirstName.sendKeys("Alphasense");
        inputCustomerLastName.sendKeys("Oy");
        inputPassword.sendKeys(password);
        this.setDateOfBirth();
        inputAddressCompany.sendKeys("Alphasense QA");
        inputAddress1.sendKeys("Ruoholahti, Helsinki");
        inputAddress2.sendKeys("NewYork");
        inputAddressCity.sendKeys("Espoo");
        this.setState();
        inputAddressPostCode.sendKeys("00000");
        this.setCountry();
        inputAddressAdditionalInformation.sendKeys("I am not a robot");
        inputAddressPhone.sendKeys("0123456789");
        submitAccountBtn.click();
        return new MyAccount(driver);
    }

    private void setDateOfBirth(){
        dropdownMenuDays.click();
        selectedDay.click();
        dropdownMenuMonths.click();
        selectedMonth.click();
        dropdownMenuYear.click();
        selectedYear.click();
    }

    private void setState(){
        dropdownMenuState.click();
        selectedState.click();
    }

    private void setCountry(){
        dropdownMenuCountry.click();
        selectedCountry.click();
    }

}
