import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostofficeDefs {

	postOffice postOfficePage;

	String zipcode;


	@Given("^check for address\"([^\"]*)\"$")
	public void flightstatus(String greeting) {
	}


	@Given("^check for address \"([^\"]*)\"$")
	public void check_for_address(String zip){
		postOfficePage = new postOffice(zip);

	}
	@When("^looking for zip code$")
	public void flightSatus() {
		zipcode = postOfficePage.checkFlight();
	}

	@Then("^get the \"([^\"]*)\"$")
	public void validateFlightOntheair(String expectedHi) {
		assertEquals(expectedHi,zipcode);
	}

}
