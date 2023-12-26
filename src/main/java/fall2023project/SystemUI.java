package fall2023project;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SystemUI {
    //admin screen
	Logger logger = Logger.getLogger(getClass().getName());
    private Product sel;
    private List<Product> allproducts = new ArrayList<Product>();
    private List<Order> myorders = new ArrayList<Order>();
    private List<String> allcategories = new ArrayList<String>();
    private List<User> allusers = new ArrayList<User>();
    private List<User> allinstallers = new ArrayList<User>();
    private List<InstallationRequest> myrequests = new ArrayList<InstallationRequest>();
    private List<Product> installableproducts = new ArrayList<Product>();
    //product data
    private String name, cat, desc;
	private double pr;
	private User customer = new User("name1", "example1@gmail.com", "32424");
	private User installer = new User("inst1", "example2@gmail.com", "adfdag");
	EmailSender sender = new EmailSender();
	
    // Private constructor to prevent instantiation from outside the class
    public SystemUI() {

    	Product p1 = new Product("prod1", "exterior", "-", 20.0);
    	Product p2 = new Product("prod2", "interior", "-", 30.0);
    	Product p3 = new Product("prod3", "exterior", "-", 45.0);
    	Product p4 = new Product("prod4", "exterior", "-", 190.0);
    	Product p5 = new Product("prod5", "interior", "-", 115.0);
    	p3.canbeinstalled();
    	p5.canbeinstalled();
    	allproducts.add(p1);
    	allproducts.add(p2);
    	allproducts.add(p3);
    	allproducts.add(p4);
    	allproducts.add(p5);
    	User u1 = new User("ahmad", "ahmad@gmail.com", "123123");
    	User u2 = new User("soad", "carrot32434@gmail.com", "54234df");
    	User u3 = new User("marah", "marah123@gmail.com", "1231fdfd");
    	allusers.add(u1);
    	allusers.add(u2);
    	allusers.add(u3);
    	Order o1 = new Order(p1, customer);
    	Order o2 = new Order(p1, customer);
    	myorders.add(o1);
    	myorders.add(o2);
    	installer.setAsInstaller();
    	InstallationRequest r1 = new InstallationRequest(u1, installer, "hyundai", p1, "11/12/2023");
    	InstallationRequest r2 = new InstallationRequest(u2, installer, "kia", p3, "23/12/2023");
    	myrequests.add(r1);
    	myrequests.add(r2);
    	
    	for(int i = 0; i < allproducts.size(); i++) {
    		if(allproducts.get(i).isinstallable())
    			installableproducts.add(allproducts.get(i));
    	}
    	User i1 = new User("good_installer", "installer1@gmail.com", "123123");
    	User i2 = new User("not_so_good_installer", "installer2@gmail.com", "54234df");
    	User i3 = new User("bad_installer", "installer3@gmail.com", "1231fdfd");
    	i1.setAsInstaller();
    	i2.setAsInstaller();
    	i3.setAsInstaller();
    	i1.addinstallerdates("2023-12-05");
    	i1.addinstallerdates("2023-12-07");
    	i1.addinstallerdates("2023-12-09");
    	i2.addinstallerdates("2023-12-05");
    	i2.addinstallerdates("2023-12-15");
    	i3.addinstallerdates("2023-12-05");
    	allinstallers.add(i1);
    	allinstallers.add(i2);
    	allinstallers.add(i3);
    	availibleinstallers.add(i1);
    	availibleinstallers.add(i2);
    	}
    public void adminscreen() {
    	 logger.info("\n--------- ADMIN'S PORTAL ------------");
    	 logger.info("1. Manage Products");
    	 logger.info("2. Categories");
    	 logger.info("3. Users");
    }

    
    
    public void readproductdata(String n, String c, String d, double p) {
    	logger.info("to add product, enter product data:");
        
    	logger.info("product name: ");
    	logger.info(n + "\n");
        name = n;  
        logger.info("product category: ");
        logger.info(c + "\n");
    	cat = c;
    	logger.info("product description: ");
    	logger.info(d + "\n");
    	desc = d;
    	logger.info("product price: ");
    	logger.info(p + "\n");
    	pr = p;
    }
    
    public void addproduct() {
        sel = new Product(name, cat, desc, pr);
        allproducts.add(sel);
        String prints = name + " has been added to system!";
        logger.info(prints);
    }

    public void printproducts() {
        String prints;
        logger.info("\n--------- PRODUCTS ------------");
        for (int i = 0; i < allproducts.size(); i++) {
            prints = (i + 1) + "." + " " + allproducts.get(i).getName();
            logger.info(prints);
        }
        logger.info("--------------------------");
    }

    public void manageproducts() {
    	logger.info("\n\n--------------------------");
    	logger.info("press * to add a new product or select an item from the list \n to delete it or update it");
        printproducts();
    }
    int currentproductindex = 0;
    

    public void readproduct(int r) {
    	currentproductindex = r - 1;
    	logger.info("you've selected " + allproducts.get(currentproductindex).getName()+ ", would you like to:");
    	logger.info("1. Update product");
    	logger.info("2. Delete product");
    	logger.info("3. Cancel");
    }
    
    public void deleteproduct() {
    	String pname = allproducts.get(currentproductindex).getName();
    	allproducts.remove(currentproductindex);
    	logger.info("deleted " + pname + " successfully" );
    	this.printproducts();
    }
    
    
    public void updateordelete(int choice) {
    	if(choice == 1) {
    		logger.info("your choice is Update");
    	}
    	else if(choice == 2) {
    		logger.info("your choice is delete");
    	}
    	else
    		logger.info("operation canceled");
    }
    public void updateproduct(String n, String c, String d, double p) {
    	name = allproducts.get(currentproductindex).getName();
    	cat = allproducts.get(currentproductindex).getCategory();
    	desc = allproducts.get(currentproductindex).getDescription();
    	pr = allproducts.get(currentproductindex).getPrice();
    	logger.info("old data: " + name + ", " + cat + ", " + desc + ", "+ pr);
    	allproducts.get(currentproductindex).setName(n);
    	allproducts.get(currentproductindex).setDescription(d);
    	allproducts.get(currentproductindex).setCategory(c);
    	allproducts.get(currentproductindex).setPrice(p);
    	logger.info("product updated! \nnew data: " + n + ", " + c + ", " + d + ", "+ p);
    }

    public void allcategories() {
    	logger.info("\n--------- CATEGORIES ------------");
        allcategories = allproducts.stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());
        String prints;
        for (int i = 0; i < allcategories.size(); i++) {
            prints = (i + 1) + "." + " " + allcategories.get(i);
            logger.info(prints);
            
        }
        logger.info("\n---------------------");
    }
    public void deletecategory(String currentcategory) {
    	logger.info("you've selected: "+ currentcategory);
    	for(int i = 0; i < allproducts.size(); i++) {
	    	if(allproducts.get(i).getCategory().equalsIgnoreCase(currentcategory))
	    		allproducts.remove(i);
	    }
    	logger.info(currentcategory + " was deleted with all associated products");
    	this.printproducts();
    	this.allcategories();
    }
    
    public void usermanagement() {
    	String printu;
    	logger.info("\n--------- SYSTEM USERS ------------");
    	for (int i = 0; i < allusers.size(); i++) {
            printu = (i + 1) + "." + " " + allusers.get(i).getUsername() + ": " + allusers.get(i).getEmail();
            System.out.println(printu);
        }
    	logger.info("--------------------------");
    }
    User selected;
    int curruser;
    public void selectuser(int index) {
    	selected = new User(allusers.get(index).getUsername(),allusers.get(index).getEmail(), allusers.get(index).getPassword());
    	curruser = index - 1;
    	logger.info("You selected user " + allusers.get(curruser).getUsername());
    }
    
    public void deleteuser() {
    	logger.info("user "+ allusers.get(curruser).getUsername()+ " has been removed from system");
    	allusers.remove(curruser);
    	this.usermanagement();
    }
    
    //----------------------- CUSTOMERS --------------------------------------
    public void customerportal() {
    	logger.info("\n");
    	logger.info("--------- CUSTOMER'S PORTAL ---------");
    	logger.info("1. browse products");
    	logger.info("2. my orders");
    	logger.info("3. request product installation");
    	logger.info("4. edit profile");
    }
    public void browseproducts() {
    	String prodline;
    	for(int i = 0; i < allproducts.size(); i++) {
    		prodline = (i+1) + ". " + allproducts.get(i).getName() + ": " + "\ncategory:" + allproducts.get(i).getCategory()
    				+ "   price:" + allproducts.get(i).getPrice() + "$" + "\n" + allproducts.get(i).getDescription();
    		logger.info(prodline);
    	}
    }
    int index;
    public void selectproduct(int i) {
    	index = i - 1;
    	logger.info("selected: " + allproducts.get(index).getName());
    	logger.info("order product? yes/no");
    }
    
    String orderedproductname;
    Double orderedproductprice;
    boolean orderplaced = false;
    public void orderproduct() {
    	Order arbt = new Order(allproducts.get(index), customer);
    	myorders.add(arbt);
    	logger.info("order for " +arbt.getProduct().getName()+ " has been placed.");
    	orderplaced = true;
    	orderedproductname = allproducts.get(index).getName();
    	orderedproductprice = allproducts.get(index).getPrice();
    }
    
    public boolean isOrderPlaced() {
    	return orderplaced;
    }
    
    public void vieworders() {
    	Double sum = 0.0;
    	logger.info("-------MY ORDERS-------");
    	for(int i = 0; i < myorders.size(); i++) {
    		logger.info(myorders.get(i).getProduct().getName() + " - " + myorders.get(i).getProduct().getPrice() + "$, " + myorders.get(i).getOrdertime());
    		sum = sum + myorders.get(i).getProduct().getPrice();
    	}
    	logger.info("total: " + sum + "$");
    }
    public void installersportal() {
    	logger.info("\n");
    	logger.info("---------INSTALLER'S PORTAL---------");
    	logger.info("REQUESTS("+myrequests.size()+ "): ");
    	for(int i = 0; i < myrequests.size(); i++) {
    		logger.info((i+1) +") "+ myrequests.get(i).getInstallationdate() + ": " + "install " + myrequests.get(i).getPart().getName() + " for " + myrequests.get(i).getCarmodel()
    				+ ", Requested by " + myrequests.get(i).getCustomer().getUsername());
    	}
    }
    int requestindex = 0;
    InstallationRequest currentrequest;
    public void selectrequest(int r) {
    	logger.info("Your choice: " + r);
    	currentrequest = new InstallationRequest(myrequests.get(r).getCustomer(),myrequests.get(r).getInstaller(),myrequests.get(r).getCarmodel(),myrequests.get(r).getPart(),myrequests.get(r).getInstallationdate());
    	logger.info("accept request? y/n");
    	requestindex = r;
    }
    public void acceptrequest() {
    	currentrequest.acceptrequest();
    }
    public void addappointment() {
    	List<InstallationRequest> appointments = new ArrayList<InstallationRequest>();
    	appointments.add(currentrequest);
    	logger.info("request has been accepted and added to appointments");
    	myrequests.remove(requestindex);
    }
    public void declinerequest() {
    	currentrequest.declinerequest();
    }
    
    public void deleterequest() {
    	myrequests.remove(requestindex);
    	logger.info("request #"+requestindex+" has been declined and removed.");
    	installersportal();
    }
    
    public void getRequestInstallationMenu() {
    	logger.info("Products availible for installation: ");
    	String prodline;
    	for(int i = 0; i < installableproducts.size(); i++) {
    		prodline = (i+1) + ". " + installableproducts.get(i).getName();
    		logger.info(prodline);
    	}
    }
    
    int productforinstallation;
    public void getavailibleproduct(int i ) {
    	productforinstallation = i;
    }
    
    @SuppressWarnings("unused")
	private InstallationRequest customerrequest;
    private String installdate;
    private String carmodel;
    public void readdataforinstallation(String car, String date) {
    	logger.info("You want to install product "+ installableproducts.get(currentproductindex).getName()+"\nto proceed enter your car model:");
    	logger.info(car);
    	logger.info("enter preffered date for installation in the format:yyyy-MM-dd");
    	logger.info(date);
    	installdate = date;
    	carmodel= car;
    }
    int count = 0;
    private List<User> availibleinstallers = new ArrayList<User>();
    public void getavailibleinstallers() {
    	for(int i = 0; i < allinstallers.size(); i++) {
    		for(int j = 0; j < allinstallers.get(i).getinstallerdates().size(); j++) {
    		    if(allinstallers.get(i).getinstallerdates().get(j).equals(installdate)) {
    		    	availibleinstallers.add(allinstallers.get(i));
    		    	logger.info((i+1)+". " + allinstallers.get(i).getUsername() +" is availible on "+installdate);
    		    	count++;
    		    }
        	}
    	}
    }
    
    public void noinstallersmessage() {
    	if(count == 0) {
    		logger.info("no installers availible for this date.");
    		logger.info("you can choose from these dates: ");
    		for(int i = 0; i < allinstallers.size(); i++) {
        		for(int j = 0; j < allinstallers.get(i).getinstallerdates().size(); j++) {
        			logger.info(allinstallers.get(i).getinstallerdates().get(j)+": "+ allinstallers.get(i).getUsername());
            	}
        	}
    		logger.info("cancel? yes/no: ");
    	}
    }
    
    public void confirmrequest(int i) {
    	customerrequest = new InstallationRequest(customer, availibleinstallers.get(i), carmodel,installableproducts.get(productforinstallation),installdate);
    	logger.info("installation request submitted successfully");
    	myrequests.add(currentrequest);
    	
    }
    
    public void sendInstallationRequestNotification() {
    	String notif = "You have a new request from " + customer.getUsername() + " to install " + installableproducts.get(productforinstallation).getName() 
    			+ " on " + installdate + " for " + carmodel;
    	sender.sendEmail("New Installation Request", notif);
    }
    
    
    //--------------------USER EDIT PROFILE-----------------------------------
    User sys = new User("user1", "sys@example.com", "123bde45e6");
	Profile myprofile = new Profile(sys, "+970123432", "Nablus, Palestine");
    public void editProfileScreen() {
    	logger.info("\tMY PROFILE: ");
    	logger.info("\t"+ sys.getUsername());
    	logger.info("\tEmail: " + myprofile.getEmail());
    	logger.info("\tPhone number: " + myprofile.getPhoneNumber());
    	logger.info("\tAddress: " + myprofile.getAddress());
    	logger.info("\n");
    }
    public void updateuserprofile(String email, String phonenumber, String address) {
    	myprofile.setEmail(email);
    	myprofile.setAddress(address);
    	myprofile.setPhoneNumber(phonenumber);
    	logger.info("\tupdated data: ");
    	logger.info("\t"+sys.getUsername());
    	logger.info("\tEmail: " + myprofile.getEmail());
    	logger.info("\tPhone number: " + myprofile.getPhoneNumber());
    	logger.info("\tAddress: " + myprofile.getAddress());
    	logger.info("\n");
    }
    
    
    public void sendPurchaseConfirmationEmail() {
    	String msg = "Thank you for your purchase!"+ "\nYou've ordered " + orderedproductname + " for " + orderedproductprice + "$";
    	sender.sendEmail("Order Confirmation", msg);
    }
    
}

