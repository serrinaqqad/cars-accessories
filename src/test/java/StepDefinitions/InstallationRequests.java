package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstallationRequests {
	SystemUI mysystem = new SystemUI();
	@Given("the user is a customer")
	public void the_user_is_a_customer() {
	    mysystem.customerportal();
	}

	@Given("the user is on the request installation menu")
	public void the_user_is_on_the_request_installation_menu() {
		System.out.println("Your choice: 3");
	    mysystem.getRequestInstallationMenu();
	}

	@When("the user selects {int} from the menu")
	public void the_user_selects_from_the_menu(Integer int1) {
		System.out.println("Your choice: "+int1);
	    mysystem.getavailibleproduct(int1);
	}

	@When("the user enters {string} and preferred date {string}")
	public void the_user_enters_car_and_preferred_date(String string, String string2) {
	    mysystem.readdataforinstallation(string, string2);
	}

	@Then("the user can see the list of available installers is displayed")
	public void the_user_can_see_the_list_of_available_installers_is_displayed() {
	    mysystem.getavailibleinstallers();
	}

	@Then("the user can see no installers available, view available dates")
	public void the_user_can_see_no_installers_available_view_available_dates() {
	    mysystem.noinstallersmessage();
	}
	
	int installer_id;
	@When("user selects installer {int} from menu")
	public void user_selects_installer_from_menu(Integer int1) {
	    installer_id = int1;
	}

	@Then("installation request will be submitted")
	public void installation_request_will_be_submitted() {
	    mysystem.confirmrequest(installer_id);
	}
	String confirmcancel;
	@When("user selects installer {string} from menu")
	public void user_selects_installer_from_menu(String string) {
	   confirmcancel = string; 
	}

	@Then("installation request will be canceled")
	public void installation_request_will_be_canceled() {
	    System.out.println("request has been canceled");
		
	}

}
