package in.amazon;

import java.util.HashMap;

import org.testng.annotations.Test;

import in.amazon.pageevents.HomePageEvents;
import in.amazon.pageevents.SearchPageEvents;

public class ScrapeProducts extends BaseClass {
    @Test
    public void searchProduct() {
        HomePageEvents homePageEvents = new HomePageEvents();
        SearchPageEvents searchPageEvents = new SearchPageEvents();
        homePageEvents.verifyHomePage();
        homePageEvents.searchForProduct("lg washing machine");
        searchPageEvents.validateSearchPage("lg washing machine");
        HashMap<String, String> productDetails = searchPageEvents.getAllProducts();
        productDetails.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        });
    }
}
