package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class UserRegistrationSteps {
    private RegistrationService registrationService;
    private User user;
    private boolean registrationOutcome;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        registrationService = new RegistrationService();
    }

    @When("the user enters a valid username {string}, email {string}, and password {string}")
    public void the_user_enters_a_valid_username_email_and_password(String username, String email, String password) {
        user = new User(username, email, password);
    }

    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
        registrationOutcome = registrationService.register(user);
    }

    @Then("the user should be registered successfully")
    public void the_user_should_be_registered_successfully() {
        assertTrue(registrationOutcome);
    }

    @When("the user enters a username {string} that is already taken")
    public void the_user_enters_a_username_that_is_already_taken(String username) {
        registrationService.register(new User(username, "dummy@example.com", "password"));
        user = new User(username, "new@example.com", "password");
        registrationOutcome = registrationService.register(user);
    }

    @Then("the user should be informed that the username is already taken")
    public void the_user_should_be_informed_that_the_username_is_already_taken() {
        assertFalse(registrationOutcome);
    }
}
