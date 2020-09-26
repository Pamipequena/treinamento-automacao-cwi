package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProceedToCheckoutElementMapper {

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
    public WebElement cartAdd;

    @FindBy(css = "#center_column > form > p > button")
    public WebElement cartAdd2;

    @FindBy(id = "uniform-cgv")
    public WebElement checkBox;

    @FindBy(css = "#form > p > button")
    public WebElement cartAddShipping;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    public  WebElement payBank;

    @FindBy(css = "#cart_navigation > button")
    public  WebElement confirmOrder;

}
