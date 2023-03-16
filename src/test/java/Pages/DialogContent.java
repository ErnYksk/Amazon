package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "nav-link-accountList")
    private WebElement loginButton;

    @FindBy(id = "ap_email")
    private WebElement email;

    @FindBy(id = "continue")
    private WebElement submitEmail;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "signInSubmit")
    private WebElement submitLogin;

    @FindBy(css = "[id='nav-link-accountList']>div>span")
    private WebElement accountAssertion;

    @FindBy(xpath = "//h4[text()='Important Message!']")
    private WebElement invalidDataLogin;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css = "[data-component-type='s-search-result']")
    public List<WebElement> searchResults;

    // searchResults also used for an example here

    @FindBy(id = "add-to-cart-button")
    private WebElement addButton;

    @FindBy(xpath = "(//*[text()='Added to Cart'])[2]")
    private WebElement addedAssertion;


    WebElement myElement;


    public void findAndSend(String strlement, String value) {
        switch (strlement) {
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;
            case "searchInput":
                myElement = searchInput;
                break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strlement) {
        switch (strlement) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "submitEmail":
                myElement = submitEmail;
                break;
            case "submitLogin":
                myElement = submitLogin;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "searchResults":
                int i = (int) (Math.random() * searchResults.size());
                myElement = searchResults.get(i);
                break;
            case "addButton":
                myElement = addButton;
                break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement) {
            case "accountAssertion":
                myElement = accountAssertion;
                break;
            case "invalidDataLogin":
                myElement = invalidDataLogin;
                break;
            case "addedAssertion":
                myElement = addedAssertion;
                break;
        }

        verifyContainsTextFunction(myElement, text);
    }

}
