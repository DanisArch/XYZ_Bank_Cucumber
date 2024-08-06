package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerPage extends BasePage {

    @FindBy(css = "#userSelect")
    public WebElement userSelect;

    @FindBy(css = "option[ng-repeat='cust in Customers']")
    public List<WebElement> listCustomerNames;

    @FindBy(css = "button[type='submit']")
    public static WebElement loginButton;
}