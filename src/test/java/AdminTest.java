/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import static junit.framework.Assert.assertNotNull;

//log in/ sign in
//menu:
// if admin: category(add,edit,delete), product(add,edit,delete), users(add,edit,deactivate)
//if customer: 
public class AdminTest {
    public fall2023cars obj;
    private ArrayList<User> admins;
    private User loggedInAdmin;
    
    private ArrayList<ProdCategory> categories;
    private ProdCategory newcat;
    // Dpendency injection
	public AdminTest(fall2023cars iobj) {
		super();
                this.admins = new ArrayList<User>();
		this.obj = iobj;
               User admn1 = new User("admin1", "admin1@example.com", "adminpassword", "Admin");
               User admn2 = new User("admin2", "admin2@example.com", "adminpassword", "Admin");
               admins.add(admn1);
               admins.add(admn2);
               
               newcat = new ProdCategory("interior","products for car interior, headrest pillows, seat cases, rugs... idk");
               this.categories = new ArrayList<ProdCategory>();
               categories.add(newcat);
    }
    
    
    @Given("the admin is logged in as admin")
    public void adminIsLoggedInAsAdmin() {
        // Mock admin login logic
        String enteredAdminEmail = "admin1@example.com"; // Enter the admin's email
        String enteredAdminPassword = "adminpassword"; // Enter the admin's password
        
        // Simulate login logic
        for (User admin : admins) {
            if (admin.getEmailaddress().equals(enteredAdminEmail) && admin.getPassword().equals(enteredAdminPassword)) {
                loggedInAdmin = admin;
                break; // Found a matching admin, no need to continue searching
            }
        }

        // successful login
        assertNotNull(loggedInAdmin);
    }

    @When("they navigate to the category management section")
    public void navigateToCategoryManagement() {
        // category management section
        System.out.println("Welcome, Admin!");
        System.out.println("Please select an option:");
        System.out.println("1. Category Management");
        System.out.println("2. Product Management");
        System.out.println("3. User Management");
        System.out.print("Enter your choice: ");

        // Simulate user input to select the category management option
        int choice = 1; // Replace with logic to read user input
        switch (choice) {
            case 1:
                System.out.println("Navigating to Category Management...");
                break;
            case 2:
                System.out.println("Navigating to Product Management...");
                break;
            case 3:
                System.out.println("Navigating to User Management...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    @And("they select {string} from the menu")
    public void selectOptionFromMenu(String option) {
        System.out.println("Please select an option:");
        System.out.println("1. Add new category.");
        System.out.println("2. Edit existing category");
        System.out.println("3. Delete category.");
        System.out.print("Enter your choice: ");
        
        option = "1";
        switch (option) {
            case "1":
                System.out.println("--- ADD NEW CATEGORY ---");
                break;
            case "2":
                System.out.println("--- EDIT EXISTING CATEGORY ---");
                break;
            case "3":
                System.out.println("--- DELETE CATEGORY ---");
                break;
            default:
                System.out.println("Invalid option. Please select a valid menu option.");
        }
    }

    @And("they enter the category name and description")
    public void enterCategoryNameAndDescription() {
        System.out.println("Enter Category name: ");
        System.out.println("Enter category description:");
        
    }

    @And("they click {string}")
    public void clickButton(String button) {
        int choice = 0;
        System.out.println("Save new category?");
    }

    @Then("the new category is added to the list")
    public void newCategoryIsAdded() {
        newcat = new ProdCategory("some caetgory","this is a description.");
        categories.add(newcat);
        System.out.println("New category added.");
    }
    
    @When("they select an existing category from the menu")
    public void selectExistingCategoryFromMenu() {
        for(int i = 0; i <= categories.size(); i++){
         System.out.println(categories.get(i));
        }
    }

    @And("they select the {string} option")
    public void selectOption(String option) {
        // Implement selecting an option, e.g., "Edit" or "Delete"
    }

    @And("they modify the category's name or description")
    public void modifyCategoryNameOrDescription() {
        // Implement modifying the category's name or description
    }

    @Then("the category details are updated")
    public void categoryDetailsAreUpdated() {
        // Implement verification that the category details are updated
    }

    @And("confirm the deletion")
    public void confirmDeletion() {
        // Implement confirming the deletion action
    }

    @Then("the category is removed from the system")
    public void categoryIsRemovedFromSystem() {
        // Implement verification that the category is removed from the system
    }
}
