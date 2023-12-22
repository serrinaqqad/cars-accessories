package fall2023project;

import java.util.HashMap;
import java.util.Map;

public class AdminDashboard {
    private Map<String, String> productCategories;

    public AdminDashboard() {
        // Initialize productCategories map
        productCategories = new HashMap<>();
    }

    public boolean addProductCategory(String categoryName) {
        // Check if the category already exists
        if (productCategories.containsKey(categoryName)) {
            return false; // Category already exists, operation failed
        }

        // Add the new category
        productCategories.put(categoryName, categoryName);
        return true; // Operation successful
    }

    public boolean editProductCategory(String oldName, String newName) {
        // Check if the old category exists
        if (!productCategories.containsKey(oldName)) {
            return false; // Old category doesn't exist, operation failed
        }

        // Update the category name
        productCategories.put(newName, productCategories.remove(oldName));
        return true; // Operation successful
    }

    public boolean deleteProductCategory(String categoryName) {
        // Check if the category exists
        if (!productCategories.containsKey(categoryName)) {
            return false; // Category doesn't exist, operation failed
        }

        // Remove the category
        productCategories.remove(categoryName);
        return true; // Operation successful
    }

    public String getProductCategoryByName(String categoryName) {
        // Return the category name or null if not found
        return productCategories.get(categoryName);
    }
}
