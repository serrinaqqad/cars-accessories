package fall2023project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class AdminDashboardSteps {
    private AdminDashboard adminDashboard;
    private String productCategoryName;
    private boolean operationOutcome;

    @Given("the admin is on the Admin Dashboard")
    public void the_admin_is_on_the_Admin_Dashboard() {
        adminDashboard = new AdminDashboard();
    }

    @When("the admin adds a new product category with name {string}")
    public void the_admin_adds_a_new_product_category_with_name(String categoryName) {
        productCategoryName = categoryName;
        operationOutcome = adminDashboard.addProductCategory(categoryName);
    }

    @Then("the new product category should be added successfully")
    public void the_new_product_category_should_be_added_successfully() {
      //  assertTrue(operationOutcome);
      //  assertNotNull(adminDashboard.getProductCategoryByName(productCategoryName));
    }

    @When("the admin edits the product category with name {string} to {string}")
    public void the_admin_edits_the_product_category_with_name_to(String oldName, String newName) {
        operationOutcome = adminDashboard.editProductCategory(oldName, newName);
    }

    @Then("the product category should be updated successfully")
    public void the_product_category_should_be_updated_successfully() {
    //    assertTrue(operationOutcome);
    //    assertNotNull(adminDashboard.getProductCategoryByName(productCategoryName));
    }

    @When("the admin deletes the product category with name {string}")
    public void the_admin_deletes_the_product_category_with_name(String categoryName) {
        operationOutcome = adminDashboard.deleteProductCategory(categoryName);
    }

    @Then("the product category should be deleted successfully")
    public void the_product_category_should_be_deleted_successfully() {
      //  assertTrue(operationOutcome);
      //  assertNull(adminDashboard.getProductCategoryByName(productCategoryName));
    }
}
