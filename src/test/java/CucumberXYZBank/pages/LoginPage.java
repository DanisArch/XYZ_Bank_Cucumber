package CucumberXYZBank.pages;

import CucumberXYZBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "strong[class='mainHeading']")
    public WebElement logoBank;

    @FindBy(css = "div:nth-child(1) > button[ng-click='customer()']")
    public WebElement customerLoginButton;

    @FindBy(css = "div:nth-child(3) > button[ng-click='manager()']")
    public  WebElement BankManagerLoginButton;
}
