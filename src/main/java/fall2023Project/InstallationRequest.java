package fall2023Project;

public class InstallationRequest {
	private User customer;
	private User installer;
	private String carmodel;
	private Product part;
	private String installationdate; 
	boolean accepted = false;
	
	
	public InstallationRequest(User c, User i, String car, Product p, String date) {
		customer = new User(c.getUsername(),c.getEmail(),c.getPassword());
		installer = new User(i.getUsername(),i.getEmail(),i.getPassword());
		carmodel = car;
		part = new Product(p.getName(),p.getCategory(),p.getDescription(),p.getPrice());
		installationdate = date;
	}
	
	public void acceptrequest() {
		accepted = true;
	}

	public void declinerequest() {
		accepted = false;
	}

	public User getCustomer() {
		return customer;
	}



	public void setCustomer(User customer) {
		this.customer = customer;
	}



	public User getInstaller() {
		return installer;
	}



	public void setInstaller(User installer) {
		this.installer = installer;
	}



	public String getCarmodel() {
		return carmodel;
	}



	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}



	public Product getPart() {
		return part;
	}



	public void setPart(Product part) {
		this.part = part;
	}



	public String getInstallationdate() {
		return installationdate;
	}



	public void setInstallationdate(String installationdate) {
		this.installationdate = installationdate;
	}
	
	
}
