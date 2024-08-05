package CucumberXYZBank.pages;

import CucumberXYZBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "strong > span[class='fontBig ng-binding']")
    public WebElement welcomeUserName;

    @FindBy(css = "#accountSelect")
    public WebElement listAccountNummerCustomer;

    @FindBy(css = "div:nth-child(3) > strong:nth-child(1)")
    public WebElement selectedAccountNummerOfCustomer;

    @FindBy(css = "div:nth-child(3) > strong:nth-child(2)")
    public WebElement balanceOfCustomer;

    @FindBy(css = "div:nth-child(3) > strong:nth-child(3)")
    public WebElement currency;

    @FindBy(css = "button[ng-click='transactions()']")
    public WebElement transactionsButton;
    //Раздел с депозитами
    @FindBy(css = "button[ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(css = "input[ng-model='amount']")
    public WebElement amountToBeDeposited;

    @FindBy(css = "button[class='btn btn-default']")
    public WebElement putMoneyOnDepositButton;
    //Снятие средств
    @FindBy(css = "button[ng-click='withdrawl()']")
    public WebElement withdrawlButton;

    @FindBy(css = "input[ng-model='amount']")
    public WebElement amountToBeWithdrawn;

    @FindBy(css = "button[class='btn btn-default']")
    public WebElement withdrawMoneyButton;

    @FindBy(css = "button[ng-click='byebye()']")
    public WebElement logoutButton;
}