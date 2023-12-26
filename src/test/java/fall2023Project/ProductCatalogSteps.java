package fall2023Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;

import fall2023Project.Catalog;
import fall2023Project.Product;

import static org.junit.Assert.*;

public class ProductCatalogSteps {
    private Catalog catalog;
    private Product selectedProduct;
    private List<Product> productsInView;

    @Given("the user is on the product catalog page")
    public void the_user_is_on_the_product_catalog_page() {
        catalog = new Catalog();
        catalog.addProduct(new Product("Premium Car Seat Covers", "Interior", "Luxurious seat covers", 199.99));
    }

    @When("the user selects the {string} category")
    public void the_user_selects_the_category(String category) {
        productsInView = catalog.getProductsByCategory(category);
    }

    @Then("the user should see a list of products related to {string} accessories")
    public void the_user_should_see_a_list_of_products_related_to_accessories(String category) {
        for (Product product : productsInView) {
            assertEquals(category, product.getCategory());
        }
    }

    @When("the user selects a product called {string}")
    public void the_user_selects_a_product_called(String productName) {
        selectedProduct = catalog.getProductDetails(productName);
    }

    @Then("the user should see the details of the {string}")
    public void the_user_should_see_the_details_of_the(String productName) {
        assertNotNull(selectedProduct);
        assertEquals(productName, selectedProduct.getName());
    }
}
