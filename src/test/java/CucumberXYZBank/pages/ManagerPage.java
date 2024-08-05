package CucumberXYZBank.pages;

import CucumberXYZBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends BasePage {
    public ManagerPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement addNewCustomerButton;

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement openCustomerAccountButton;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement showAllCustomersButton;
}
