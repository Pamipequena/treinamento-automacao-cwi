package pageObjects;

import com.github.javafaker.Internet;
import elementMapper.MyAccountPageElementMapper;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

public class MyAccountPage extends MyAccountPageElementMapper {

    public MyAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    Faker faker = new Faker();

    public void KeyEmailCreate(){
       emailCreate.sendKeys(faker.bothify("?????####@gmail.com"));
    }

    public void clickBtnSubmitCreate(){
        submitCreate.click();
    }

    public void clickCheckGender(){
        gender.click();
    }

    public void createFirstName(){
        firstName.sendKeys(faker.name().firstName());
    }

    public void createLastName(){
        lastName.sendKeys(faker.name().lastName());
    }

    public void createPasswd(){
        passwd.sendKeys(faker.bothify("###?##????"));
    }

    public void selectDays(){
        Select selectDayElement = new Select(days);
        selectDayElement.selectByValue("10");
    }

    public void selectMonths(){
        Select selectMonthsElement = new Select(months);
        selectMonthsElement.selectByValue("3");
    }

    public void selectYears(){
        Select selectYearsElement = new Select(years);
        selectYearsElement.selectByValue("1994");
    }

    public void createAdress(){
        address1.sendKeys(faker.address().streetName());
    }

    public void createCity(){
        city.sendKeys(faker.address().city());
    }

    public void selectState(){
        Select selectStateElement = new Select(state);
        selectStateElement.selectByVisibleText("California");
    }

    public void createPostCode(){
        postCode.sendKeys("00000");
    }

    public void createPhoneMobile(){
        phoneMobile.sendKeys(faker.phoneNumber().cellPhone());
    }

    public void createAlias(){
        alias.click();
        alias.sendKeys(" House");
    }

    public void clickBtnSubmitAccount(){
        submitAccount.click();
    }


}
