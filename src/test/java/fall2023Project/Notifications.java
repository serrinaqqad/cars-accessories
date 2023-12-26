package fall2023Project;
import fall2023Project.SystemUI;
import io.cucumber.java.en.Then;

public class Notifications {
	SystemUI mysystem = new SystemUI();

	@Then("the customer should receive an order confirmation email")
	public void the_customer_should_receive_an_order_confirmation_email() {
		mysystem.sendPurchaseConfirmationEmail();
	}

	@Then("the installer should receive a notification about the new installation request")
	public void the_installer_should_receive_a_notification_about_the_new_installation_request() {
	    mysystem.sendInstallationRequestNotification();
	}

}
