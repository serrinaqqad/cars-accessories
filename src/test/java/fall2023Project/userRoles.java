package fall2023Project;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import fall2023Project.InstallationRequest;
import fall2023Project.Order;
import fall2023Project.Product;
import fall2023Project.SystemUI;
import fall2023Project.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userRoles {
	SystemUI mysystem = new SystemUI();
	User admin1 = new User("admin1","admin@gmail.com", "123123");
	User customer1 = new User("customer1", "customer1@yandex.com", "1blabla");
	User customer2 = new User("customer2", "customer2@yandex.com", "2blabla");
	User customer3 = new User("customer3", "customer3@yandex.com", "3blabla");
	User installer1 = new User("installer1", "installer@gmail.com", "0000");
	
	Product newproduct;
	Product selectedProduct;
	String currentpage;
	String currentcategory;
	User selecteduser;
	List<Product> allProducts = new ArrayList<Product>();
	Product p1 = new Product("prod1", "exterior", "-", 20.0);
	Product p2 = new Product("prod2", "interior", "-", 30.0);
	Product p3 = new Product("prod3", "exterior", "-", 15.0);
	List<String> allCategories = new ArrayList<String>();
	List<User> allUsers = new ArrayList<User>();
	String product_choice = null;
	
	InstallationRequest r1 = new InstallationRequest(customer1, installer1, "toyota", p1, "11/12/2023 - 12:00");
	InstallationRequest r2 = new InstallationRequest(customer2, installer1, "kia", p3, "23/12/2023 - 11:00");
	public userRoles() {
		allProducts.add(p1);
		allProducts.add(p2);
		allProducts.add(p3);
		allUsers.add(customer1);
		allUsers.add(customer2);
		allUsers.add(customer3);
		allrequests.add(r1);
		allrequests.add(r2);
	}
	
	
	@Given("user is an admin")
	public void user_is_an_admin() {
	    admin1.setAsAdmin();
	    mysystem.adminscreen();
	}

	@Given("user is on the add product page")
	public void user_is_on_the_add_product_page() {
		//currentpage = "add new product";
		mysystem.manageproducts();
		System.out.println("*");
	}

	@When("user enters product {string}, {string}, {string} and {double}")
	public void user_enters_product_name_category_description_and_price(String name, String category, String description, double price) {
	  // newproduct = new Product(name, category, description, price);
	    mysystem.readproductdata(name, category, description, price);
	}

	@Then("new product should be added to the system")
	public void new_product_should_be_added_to_the_system() {
	   //allProducts.add(newproduct);
	    mysystem.addproduct();
	}
	
	String pname = null;
	String pdesc = null;
	String pcategory = null;
	double price = 0.0;
	
	@Given("user is on product menu")
	public void user_is_on_product_menu() {
	    mysystem.manageproducts();
	}

	@When("user selects {int} from the menu")
	public void user_selects_a_product_from_the_menu(int menuOption) {
	    mysystem.readproduct(menuOption);
	}

	@When("user clicks update product from system")
	public void user_clicks_update_product_from_system() {
	    mysystem.updateordelete(1);
	    product_choice = "update";
	}

	@When("user {string} product from system")
	public void user_clicks_action_product_from_system(String action) {
	    if (action.equals("clicks update")) {
	        product_choice = "update";
	    } else if (action.equals("clicks delete")) {
	        product_choice = "delete";
	    }
	}
	
    @Then("the product should be updated successfully")
	public void the_product_should_be_updated_successfully() {
    	if(product_choice == "update") {
    	pname = "headrest";
    	pcategory = "interior";
    	pdesc = "pillow size 40 * 30 cm";
    	price = 20.0;
		mysystem.updateproduct(pname, pcategory, pdesc, price);
		mysystem.printproducts();
    	}
	}
	@When("user clicks delete product from system")
	public void user_clicks_delete_product_from_system() {
	    product_choice = "delete";
	    mysystem.updateordelete(2);
	}
	@Then("the product should be removed from system")
	public void the_product_should_be_removed_from_system() {
			mysystem.deleteproduct();
	}
	


	@Given("user is on category menu")
	public void user_is_on_category_menu() {
		mysystem.allcategories();
	}

	@When("user selects a {string} from the menu")
	public void user_selects_a_category_from_the_menu(String category) {
		currentcategory = category;
	}

	boolean delete_category = false;
	@When("user confirms category deletion")
	public void user_confirms_category_deletion() {
	    delete_category = false;
	}

	@Then("category and all related products will be deleted from the system")
	public void category_and_all_related_products_will_be_deleted_from_the_system() {
		if(delete_category == true) {
			mysystem.deletecategory(currentcategory);
		}
		else
			System.out.println("canceled: delete category");
	    
	}

	@Given("user is on user management section")
	public void user_is_on_user_management_section() {
	    mysystem.usermanagement();
	}

	@When("admin selects a {int} from the menu")
	public void admin_selects_a_user_from_the_menu(int selected) {
	    selecteduser = new User(allUsers.get(selected).getUsername(),allUsers.get(selected).getEmail(), allUsers.get(selected).getPassword());
		mysystem.selectuser(selected);
	}

	boolean flag = false;
	@When("user confirms user deletion")
	public void user_confirms_user_deletion() {
	    flag = true;
	    System.out.println("deletion confirmed");
	}

	@Then("user account will be deleted")
	public void user_account_will_be_deleted() {
		if(flag == true) {
			mysystem.deleteuser();
		}
		
	}

	@Given("user is a customer")
	public void user_is_a_customer() {
	     if(customer1.getRole() == "customer") {
	    	 mysystem.customerportal();
	     }
	}

	@Given("user is on the browse products menu")
	public void user_is_on_the_browse_products_menu() {
	    mysystem.browseproducts();
	}

	@When("user selects a {int} from the list")
	public void user_selects_a_product_from_the_list(int selected) {
	    selectedProduct = allProducts.get(selected);
	    mysystem.selectproduct(selected);
	}

	Order prodorder;
	List<Order> clientorders = new ArrayList<Order>();
	@When("clicks on order product")
	public void clicks_on_order_product() {
		prodorder = new Order(selectedProduct, customer1 );
		mysystem.orderproduct();
	}

	@Then("the customer should see a confirmation message for the order")
	public void the_customer_should_see_a_confirmation_message_for_the_order() {
	   // prodorder.confirmorder();
		System.out.println("order added to cart");
	}

	@When("user navigates to view orders menu")
	public void user_navigates_to_view_orders_menu() {
	    currentpage = "view orders";
	    mysystem.vieworders();
	}

	@Then("user will see all previous orders")
	public void user_will_see_all_previous_orders() {
	    clientorders.toString();
	}

	@Given("user is an installer")
	public void user_is_an_installer() {
	    installer1.setAsInstaller();
	}

	@Given("user is in the installation request menu")
	public void user_is_in_the_installation_request_menu() {
	    mysystem.installersportal();
	}
	InstallationRequest currentrequest;
	List<InstallationRequest> allrequests = new ArrayList<InstallationRequest>();
	List<InstallationRequest> appointments = new ArrayList<InstallationRequest>();
	@When("user selects a {int} from the menu")
	public void user_selects_a_request_from_the_menu(int r) {
	    currentrequest = new InstallationRequest(allrequests.get(r).getCustomer(),allrequests.get(r).getInstaller(),allrequests.get(r).getCarmodel(),allrequests.get(r).getPart(),allrequests.get(r).getInstallationdate());
	    mysystem.selectrequest(r); 
	}
	boolean accept = false;
	@When("user accepts installation request")
	public void user_accepts_installation_request() {
		accept = true; 
	    currentrequest.acceptrequest();
	    mysystem.acceptrequest();
	}

	@Then("the request is added to installers appointments")
	public void the_request_is_added_to_installers_appointments() {
	    appointments.add(currentrequest);
	    mysystem.addappointment();
	}

	@When("user declines installation request")
	public void user_declines_installation_request() {
	    currentrequest.declinerequest();
	    mysystem.declinerequest();
	}

	@Then("the request will be deleted")
	public void the_request_will_be_deleted() {
		mysystem.deleterequest();
	}
}
