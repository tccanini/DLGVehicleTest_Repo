package uk.co.vwfsins.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.vwfsins.waits.WebWaits;
import uk.co.vwfsins.webControls.ClickControl;
import uk.co.vwfsins.webControls.TextFieldsControl;

public class VehicleStartPage extends BasePage {


    @FindBy(id = "vehicleReg")
    private WebElement vehicleReg = null;
    @FindBy(css = "form > button > span")
    private WebElement findVehicleButton = null;
    @FindBy(css = "div.result")
    private WebElement resultMessage = null;
    @FindBy(css = "form > div")
    private WebElement errorMessage = null;
    @FindBy(css = "div:nth-child(4) > div.result")
    private WebElement validRegMessage = null;
    @FindBy(css = "div:nth-child(2) > span")
    private WebElement coverStartMessage = null;
    @FindBy(css = "div:nth-child(3) > span")
    private WebElement coverEndMessage = null;


    public VehicleStartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VehicleStartPage enterVehRegNo(String regNo) {
        TextFieldsControl.enterText(vehicleReg, regNo);
        return this;
    }

    public VehicleStartPage findVehicle() {
        ClickControl.click(findVehicleButton);
        WebWaits.waitForNoOfSeconds(1);
        return this;
    }

    public boolean validateMessage(String message) {
        return resultMessage.getText().equalsIgnoreCase(message);
    }

    public boolean validateErrorMessage(String eMessage) {
        return errorMessage.getText().equalsIgnoreCase(eMessage);
    }

    public boolean validateResult(String result) {
        return validRegMessage.getText().equalsIgnoreCase(result);
    }

    public boolean validateCoverStartDate(String coverStart) {
        return coverStartMessage.getText().equalsIgnoreCase(coverStart);
    }

    public boolean validateCoverEndDate(String coverEnd) {
        return coverEndMessage.getText().equalsIgnoreCase(coverEnd);
    }
}
