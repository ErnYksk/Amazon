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

    @FindBy(xpath = "//*[text()='Giriş Yap']")
    private WebElement loginButton;

    @FindBy(id = "login-email")
    private WebElement email;

    @FindBy(id = "login-password-input")
    private WebElement password;

    @FindBy(xpath = "//*[text()='Hesabım']")
    private WebElement hesabim;

    @FindBy(xpath = "//span[text()='E-posta adresiniz ve/veya şifreniz hatalı.']")
    private WebElement invalidDataLogin;

    @FindBy(xpath = "//button[@type='submit']//span")
    private WebElement submitLogin;

    @FindBy(xpath = "//*[text()='KABUL ET']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")
    private WebElement searchInput;

    @FindBy(xpath = "//i[@data-testid='search-icon']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='p-card-wrppr with-campaign-view']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//button[@class='add-to-basket']//div[text()='Sepete Ekle']")
    private WebElement addButton;
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
            case "submitLogin":
                myElement = submitLogin;
                break;
            case "acceptCookies":
                myElement = acceptCookies;
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
            case "hesabim":
                myElement = hesabim;
                break;
            case "invalidDataLogin":
                myElement = invalidDataLogin;
                break;
        }

        verifyContainsTextFunction(myElement, text);
    }

}
