package fall2023project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Object> getProductsByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Product getProductDetails(String productName) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }
}
