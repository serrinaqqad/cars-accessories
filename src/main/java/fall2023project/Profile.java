package fall2023project;

public class Profile {
 User user;
 String phoneNumber;
 String address;
 
 public Profile(User u, String n, String a) {
	 user = new User(u.getUsername(),u.getEmail(), u.getPassword());
	 phoneNumber = n;
	 address = a;
 }

public User getUser() {
	return user;
}

public void setEmail(String email) {
	this.user.setEmail(email);
}
public String getEmail() {
	return this.user.getEmail();
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
}
