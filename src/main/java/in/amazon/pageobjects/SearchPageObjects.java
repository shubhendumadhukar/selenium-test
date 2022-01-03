package in.amazon.pageobjects;

public class SearchPageObjects {
    public static String PRODUCT_TITLE_XPATH = "//div[contains(@data-cel-widget, 'MAIN-SEARCH_RESULTS')]//span[contains(@class,'a-size-medium')]";

    public String getProductTitleXPath(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("//div[contains(@data-cel-widget, 'MAIN-SEARCH_RESULTS-");
        sb.append(id);
        sb.append("')]//span[contains(@class,'a-size-medium')]");
        return sb.toString();
    }

    public String getProductPriceXpath(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("//div[contains(@data-cel-widget, 'MAIN-SEARCH_RESULTS-");
        sb.append(id);
        sb.append("')]//span[contains(@data-a-color,'price')]//span[contains(@class,'a-price-whole')]");
        return sb.toString();
    }

    public String getSearchResultXPath(String searchTerm) {
        StringBuilder sb = new StringBuilder();
        sb.append("//span[contains(text(),'\"");
        sb.append(searchTerm);
        sb.append("\"')]");
        return sb.toString();
    }
}
