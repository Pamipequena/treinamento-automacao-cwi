package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.awt.windows.WWindowPeer;

public class MyAccountPageElementMapper {

    @FindBy( id = "email_create")
    public WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    public WebElement submitCreate;

    @FindBy(id = "id_gender1")
    public WebElement gender;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy( id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "days")
    public WebElement days;

    @FindBy(id = "months")
    public WebElement months;

    @FindBy(id = "years")
    public WebElement years;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement postCode;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobile;

    @FindBy(id = "alias")
    public WebElement alias;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    public WebElement submitAccount;
}

