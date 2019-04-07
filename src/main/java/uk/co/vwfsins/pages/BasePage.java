package uk.co.vwfsins.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public VehicleStartPage goToStartPage() {
        return PageFactory.initElements(webDriver, VehicleStartPage.class);
    }
}
