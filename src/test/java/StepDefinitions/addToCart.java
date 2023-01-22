package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class addToCart {

    DialogContent dc=new DialogContent();
    @Given("Search in item")
    public void searchInItem() {
        dc.findAndSend("searchInput","teddy bear");
        dc.findAndClick("searchButton");

    }

    @And("Choose an item randomly")
    public void chooseAnItemRandomly(DataTable elements) {
        List<String> listElemanlar= elements.asList(String.class);

        for(String strButtonName : listElemanlar)
            dc.findAndClick(strButtonName);
    }

    @Then("Add item to cart")
    public void addItemToCart(DataTable elements) {
        GWD.getDriver().getWindowHandles().forEach(tab->GWD.getDriver().switchTo().window(tab));
        List<String> listElemanlar= elements.asList(String.class);

        for(String strButtonName : listElemanlar)
            dc.findAndClick(strButtonName);
    }

    @And("Item should be appeared in cart")
    public void itemShouldBeAppearedInCart() {
        dc.findAndContainsText("addedAssertion","Added");
    }
}
