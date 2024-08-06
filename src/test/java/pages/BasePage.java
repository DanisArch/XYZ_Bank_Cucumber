package pages;

import context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(TestContext.getDriver(), this);
    }
}