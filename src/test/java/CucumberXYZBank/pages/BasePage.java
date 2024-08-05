package CucumberXYZBank.pages;

import CucumberXYZBank.context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(TestContext context){
        PageFactory.initElements(TestContext.getDriver(), this);
    }

}