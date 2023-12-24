package fall2023project;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order {
	private Product product;
	private User customer;
	String ordertime;
	boolean proceeding;
	
	public Order(Product p, User c) {
		product = new Product(p.getName(),p.getCategory(),p.getDescription(),p.getPrice());
		customer = new User(c.getUsername(),c.getEmail(),c.getPassword());
		ordertime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		proceeding = true;
	}
	
	public void confirmorder() {
		proceeding = false;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
}
