package in.amazon.pageevents;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import in.amazon.pageobjects.HomePageObjects;
import in.amazon.utils.FetchBy;
import in.amazon.utils.FetchElements;

public class HomePageEvents {
    public void verifyHomePage() {
        FetchElements fetchElements = new FetchElements();
        List<WebElement> cart = fetchElements.getWebElements(FetchBy.ID, HomePageObjects.CART_LINK_ID);
        Assert.assertTrue(cart.size() > 0, "Home page did not launch correctly");
    }

    public void searchForProduct(String searchTerm) {
        FetchElements fetchElements = new FetchElements();
        WebElement searchInput = fetchElements.getWebElement(FetchBy.ID, HomePageObjects.SEARCH_INPUT_ID);
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
        WebElement searchButton = fetchElements.getWebElement(FetchBy.ID, HomePageObjects.SEARCH_BUTTON_ID);
        searchButton.click();
    }
}
