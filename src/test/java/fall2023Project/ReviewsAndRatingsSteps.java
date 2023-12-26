package fall2023Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import fall2023Project.ProductDetailsPage;
import fall2023Project.Review;
import fall2023Project.ReviewService;

public class ReviewsAndRatingsSteps {
    private ProductDetailsPage productDetailsPage;
    private ReviewService reviewService;
    private String productName;
    private Review submittedReview;
    private double averageRating;
    private int reviewsCount;

    @Given("the customer is on the product details page for {string}")
    public void the_customer_is_on_the_product_details_page_for(String productName) {
        productDetailsPage = new ProductDetailsPage();
        this.productName = productName;
    }

    @When("the customer leaves a review with the title {string} and rating {int}")
    public void the_customer_leaves_a_review_with_the_title_and_rating(String reviewTitle, int rating) {
        submittedReview = new Review(reviewTitle, rating);
        reviewService = new ReviewService();
        reviewService.submitReview(productName, submittedReview);
    }

    @Then("the review and rating should be submitted successfully")
    public void the_review_and_rating_should_be_submitted_successfully() {
        assertNotNull(submittedReview);
    }

    @Then("the product page should display the average rating and reviews count")
    public void the_product_page_should_display_the_average_rating_and_reviews_count() {
        averageRating = reviewService.getAverageRating(productName);
        reviewsCount = reviewService.getReviewsCount(productName);

        assertEquals(5.0, averageRating, 0.001); 
        assertEquals(1, reviewsCount); 
    }
}
