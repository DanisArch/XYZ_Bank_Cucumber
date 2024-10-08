package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomerPage extends BasePage {

    @FindBy(css = "input[ng-model='fName']")
    public WebElement userFirstName;

    @FindBy(css = "input[ng-model='lName']")
    public WebElement userLastName;

    @FindBy(css = "input[ng-model='postCd']")
    public WebElement postCode;

    @FindBy(css = "button[type='submit']")
    public WebElement addNewCustomerButton;
}