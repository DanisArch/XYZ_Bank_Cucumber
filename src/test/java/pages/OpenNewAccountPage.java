package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewAccountPage extends BasePage {

    @FindBy(css = "select[id='userSelect']")
    public WebElement customerName;

    @FindBy(css = "select[id='currency']")
    public WebElement selectCurrency;

    @FindBy(css = "button[type='submit']")
    public WebElement processSubmitButton;
}
