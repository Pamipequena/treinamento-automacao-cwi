package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    @FindBy(className = "login")
    public WebElement login;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "SubmitLogin")
    public WebElement SubmitLogin;
}
