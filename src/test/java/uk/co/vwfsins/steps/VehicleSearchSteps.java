package uk.co.vwfsins.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.vwfsins.pages.VehicleStartPage;
import uk.co.vwfsins.support.WorldHelper;
import uk.co.vwfsins.utilities.TestData;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class VehicleSearchSteps {

    private WorldHelper helper;
    private VehicleStartPage startPage;

    public VehicleSearchSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the VFS Page$")
    public void iAmOnTheVFSPage() {
        startPage = helper.getBasePage().goToStartPage();
    }


    @When("^I search with a \"([^\"]*)\" and click to find vehicle$")
    public void iSearchWithAAndClickToFindVehicle(String validVehicleReg) throws Throwable {
        validVehicleReg = TestData.getValue(validVehicleReg);
        startPage.enterVehRegNo(validVehicleReg).findVehicle();
    }

    @Then("^I should be able to see the details of the vehicle as below:$")
    public void iShouldBeAbleToSeeTheDetailsOfTheVehicleAsBelow(DataTable dataTable) {
        List<List<String>> previewDetails = dataTable.raw();
        String result = TestData.getValue(previewDetails.get(1).get(1));
        String startDate = TestData.getValue(previewDetails.get(2).get(1));
        String endDate = TestData.getValue(previewDetails.get(3).get(1));
        startPage.validateResult(result);
        startPage.validateCoverStartDate(startDate);
        startPage.validateCoverEndDate(endDate);
    }

    @When("^I search with a \"([^\"]*)\" and click to continue$")
    public void iSearchWithAAndClickToContinue(String vehicleReg){
        vehicleReg = TestData.getValue(vehicleReg);
        startPage.enterVehRegNo(vehicleReg).findVehicle();
    }

    @Then("^I should be able to see \"([^\"]*)\"$")
    public void iShouldBeAbleToSee(String message){
        message = TestData.getValue(message);
        assertThat(startPage.validateMessage(message), is(true));
    }

    @When("^I enter an \"([^\"]*)\" on the searchField and click to continue$")
    public void iEnterAnOnTheSearchFieldAndClickToContinue(String invalidReg){
        invalidReg = TestData.getValue(invalidReg);
        startPage.enterVehRegNo(invalidReg).findVehicle();
    }

    @When("^I leave the \"([^\"]*)\" and I click to continue$")
    public void iLeaveTheAndIClickToContinue(String noRegNo){
        noRegNo = TestData.getValue(noRegNo);
        startPage.enterVehRegNo(noRegNo).findVehicle();
    }

    @Then("^I should be able to see \"([^\"]*)\" displayed$")
    public void iShouldBeAbleToSeeDisplayed(String eMessage){
        eMessage = TestData.getValue(eMessage);
        assertThat(startPage.validateErrorMessage(eMessage), is(true));
    }
}


