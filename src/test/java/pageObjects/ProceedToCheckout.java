package pageObjects;

import elementMapper.ProceedToCheckoutElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProceedToCheckout extends ProceedToCheckoutElementMapper {

    public ProceedToCheckout(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }


    //clicar para finalizar compra
    public void clickBtnCartAdd(){
        cartAdd.click();
    }
    public void clickBtnCartAdd2(){
        cartAdd2.click();
    }
    public void clickCheckBox(){
        checkBox.click();
    }
    public void clickBtnShipping(){
        cartAddShipping.click();
    }
    public void clickBtnPayBank(){
        payBank.click();
    }

    public void clickBtnConfirmOrder(){
        confirmOrder.click();
    }


}
