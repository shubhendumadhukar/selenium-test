package in.amazon.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import in.amazon.BaseClass;

public class FetchElements {
    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseClass.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseClass.driver.findElement(By.cssSelector(identifierValue));
            case "XPATH":
                return BaseClass.driver.findElement(By.xpath(identifierValue));
            case "TAGNAME":
                return BaseClass.driver.findElement(By.tagName(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseClass.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseClass.driver.findElements(By.cssSelector(identifierValue));
            case "XPATH":
                return BaseClass.driver.findElements(By.xpath(identifierValue));
            case "TAGNAME":
                return BaseClass.driver.findElements(By.tagName(identifierValue));
            default:
                return null;
        }
    }
}
