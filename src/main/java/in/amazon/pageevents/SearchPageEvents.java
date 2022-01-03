package in.amazon.pageevents;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import in.amazon.pageobjects.SearchPageObjects;
import in.amazon.utils.FetchBy;
import in.amazon.utils.FetchElements;

public class SearchPageEvents {
    public void validateSearchPage(String searchTerm) {
        FetchElements fetchElements = new FetchElements();
        SearchPageObjects searchPageObjects = new SearchPageObjects();
        List<WebElement> searchText = fetchElements.getWebElements(FetchBy.XPATH,
                searchPageObjects.getSearchResultXPath(searchTerm));
        Assert.assertTrue(searchText.size() > 0, "Search page did not launch correctly");
    }

    public HashMap<String, String> getAllProducts() {
        FetchElements fetchElements = new FetchElements();
        SearchPageObjects searchPageObjects = new SearchPageObjects();
        List<WebElement> productsTitles = fetchElements.getWebElements(FetchBy.XPATH,
                SearchPageObjects.PRODUCT_TITLE_XPATH);
        System.out.println("Products found:" + productsTitles.size());
        System.out.println("Getting Product Details");
        HashMap<String, String> products = new HashMap<String, String>();
        for (int i = 2; i < productsTitles.size() + 2; i++) {
            String productPriceXPath = searchPageObjects.getProductPriceXpath(String.valueOf(i));
            String productTitleXPath = searchPageObjects.getProductTitleXPath(String.valueOf(i));
            List<WebElement> productPrice = fetchElements.getWebElements(FetchBy.XPATH, productPriceXPath);
            List<WebElement> productTitle = fetchElements.getWebElements(FetchBy.XPATH, productTitleXPath);
            if (productPrice.size() > 0) {
                products.put(productTitle.get(0).getText(), productPrice.get(0).getText());
            } else {
                products.put(productTitle.get(0).getText(), "0");
            }
        }
        return products;
    }
}
