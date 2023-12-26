package fall2023Project;

//ReviewService.java
import java.util.HashMap;
import java.util.Map;

public class ReviewService {
 private Map<String, ReviewInfo> productReviews;

 public ReviewService() {
     // Initialize productReviews map
     productReviews = new HashMap<>();
 }

 public void submitReview(String productName, Review review) {
     // Check if the product has existing reviews
     ReviewInfo reviewInfo = productReviews.getOrDefault(productName, new ReviewInfo());
     // Update review count and calculate new average rating
     reviewInfo.addReview(review.getRating());
     // Save the updated review info
     productReviews.put(productName, reviewInfo);
 }

 public double getAverageRating(String productName) {
     // Retrieve the average rating from the review info
     ReviewInfo reviewInfo = productReviews.get(productName);
     return (reviewInfo != null) ? reviewInfo.getAverageRating() : 0.0;
 }

 public int getReviewsCount(String productName) {
     // Retrieve the reviews count from the review info
     ReviewInfo reviewInfo = productReviews.get(productName);
     return (reviewInfo != null) ? reviewInfo.getReviewsCount() : 0;
 }

 // Internal class to store review information
 private static class ReviewInfo {
     private int reviewsCount;
     private double totalRating;

     public void addReview(int rating) {
         reviewsCount++;
         totalRating += rating;
     }

     public double getAverageRating() {
         return (reviewsCount > 0) ? totalRating / reviewsCount : 0.0;
     }

     public int getReviewsCount() {
         return reviewsCount;
     }
 }
}
