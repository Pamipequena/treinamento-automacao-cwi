package pageObjects;

import elementMapper.LoginPageElementMapper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Utils;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void fillEmail(){
        email.sendKeys("rrsetcwi+autopractice@gmail.com");
    }

    public void fillPasswd(){
        passwd.sendKeys("teste123");
    }

    public void clickBtnSubmitLogin(){
        SubmitLogin.click();
    }
}
