package CucumberXYZBank.pages;

import CucumberXYZBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewAccountPage extends BasePage {

    public OpenNewAccountPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "select[id='userSelect']")
    public WebElement customerName;

    @FindBy(css = "select[id='currency']")
    public WebElement selectCurrency;

    @FindBy(css = "button[type='submit']")
    public WebElement processSubmitButton;
}
