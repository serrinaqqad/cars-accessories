package fall2023Project;

import java.util.ArrayList;
import java.util.List;


public class Catalog {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

  

    public Product getProductDetails(String productName) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }
}
