package uk.co.vwfsins.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.vwfsins.browsers.WebDriverFactory;
import uk.co.vwfsins.pages.*;

public class WorldHelper {

    private WebDriver driver = WebDriverFactory.getThreadedDriver();
    private static BasePage basePage = null;
    private static VehicleStartPage startPage = null;


    public BasePage getBasePage() {
        if (basePage != null) return basePage;
        return PageFactory.initElements(driver, BasePage.class);
    }

    public VehicleStartPage getStartPage() {
        if (startPage != null) return startPage;
        startPage = PageFactory.initElements(driver, VehicleStartPage.class);
        return startPage;
    }
}
