package fall2023Project;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private String role;
    private List<String> installersdates = new ArrayList<String>();
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        role = "customer";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
    	return this.role;
    }
    public void setAsAdmin() {
    	role = "admin";
    }
    public void setAsInstaller() {
    	role = "installer";
    }
    public void addinstallerdates(String date) {
    	installersdates.add(date);
    }
    public List<String> getinstallerdates(){
    	return installersdates;
    }
    
}
