package fall2023Project;

import fall2023Project.SystemUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfile {
	SystemUI mysystem = new SystemUI();
	@When("the user navigates to the Edit Profile section")
	public void the_user_navigates_to_the_edit_profile_section() {
	    mysystem.editProfileScreen();
	    
	}

	String email, phoneNumber, address;
	@When("updates contact information with new {string}, {string} and {string}")
	public void updates_contact_information_with_new_and(String string, String string2, String string3) {
		System.out.println("Enter updated email: ");
	    email = string;
	    System.out.println(email);
	    System.out.println("Enter updated phone number: ");
	    phoneNumber = string2;
	    System.out.println(phoneNumber);
	    System.out.println("Enter updated address: ");
	    address = string3;
	    System.out.println(address);
	    System.out.println("apply changes? y/n");
	}

	String choice;

    @When("user selects <{string}>")
    public void user_selects(String string) {
    choice = string;
    	switch(choice) {
    	case "y": System.out.println("y"); 
    		      System.out.println("updating profile..");
    	case "n": System.out.println("n");
    		      System.out.println("discarding..");
    	}
    }

	@Then("the users profile should be updated")
	public void the_users_profile_should_be_updated() {
		 mysystem.updateuserprofile(email, phoneNumber, address);
	}
	

	@Then("the users profile should be kept")
	public void the_users_profile_should_be_kept() {
		System.out.println("changes discarded.");
	    mysystem.customerportal();
	}

	int select;
	@When("the user navigates to the Order History section")
	public void the_user_navigates_to_the_order_history_section() {
	    mysystem.customerportal();
	    select = 2;
	}

	@Then("the user should see a list of past orders")
	public void the_user_should_see_a_list_of_past_orders() {
		mysystem.vieworders();
	}

	@When("the user navigates to the Installation Requests section")
	public void the_user_navigates_to_the_installation_requests_section() {
		mysystem.customerportal();
	    select = 3;
	}

	@Then("the user should see a list of past installation requests")
	public void the_user_should_see_a_list_of_past_installation_requests() {
	    mysystem.getRequestInstallationMenu();
	}

}
