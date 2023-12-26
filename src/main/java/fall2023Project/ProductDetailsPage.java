package fall2023Project;

public class ProductDetailsPage {
 private String productName;
 private String description;
 private double price;

 public ProductDetailsPage(String productName, String description, double price) {
     this.productName = productName;
     this.description = description;
     this.price = price;
 }

 public ProductDetailsPage() {
	  this.productName = "test";
	     this.description = "empty";
	     this.price = 0.0;
	 }

public String getProductName() {
     return productName;
 }

 public String getDescription() {
     return description;
 }

 public double getPrice() {
     return price;
 }
}
