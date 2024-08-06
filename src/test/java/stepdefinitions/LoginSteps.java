package stepdefinitions;


import context.TestContext;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    /*
    @Step("Найти логотип банка на главной странице")
    public String findLogo() {
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).logoBank));
        return logoBank.getText();
    }

    @Step("Проверяет наличие кнопки для авторизации пользователя банка на главной странице")
    public boolean checkCustomerLoginButton () {;
        boolean answr;
        if (customerLoginButton.isDisplayed()) {
            Allure.step("Кнопка для авторизации пользователя банка активна");
            answr=true;
        } else {
            Allure.step("Кнопка для авторизации пользователя банка  не активна");
            answr=false;
        }
        return answr; //customerLoginButton.isDisplayed();
    }

    @Step("Проверяет наличие кнопки для авторизации менеджера банка на главной странице")
    public boolean checkBankManagerLoginButton () {
        return BankManagerLoginButton.isDisplayed();
    }
*/
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) throws InterruptedException {
        WebElement button = null;
        if (buttonName.equals("Customer Login")) {
            button =loginPage.customerLoginButton;
        } else if (buttonName.equals("Bank Manager Login")) {
            button = loginPage.BankManagerLoginButton;
        }
        if (button != null) {
            button.click();

            Thread.sleep(3000);
        }
    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String pageName) {
        String expectedUrl = "";
        if (pageName.equals("Customer Login")) {
            expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
        } else if (pageName.equals("Bank Manager Login")) {
            expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
        }
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

/*
    @Step("Войти в приложение банка с правами менеджера")
    public ManagerPage loginAsBankManager() {
        //   context.wait.until(ExpectedConditions.visibilityOfAllElements(new LoginPage(context).BankManagerLoginButton));
        BankManagerLoginButton.click();
        return new ManagerPage(context);
    }*/
}
