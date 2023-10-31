/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class User {
    private String username;
    private String emailaddress;
    private String password;
    private String userType;
    //{"Admin", "Customer", "Installer"}
    
    public User(String username, String emailaddress, String password, String userType) {
        this.username = username;
        this.emailaddress = emailaddress;
        this.password = password;
        this.userType = userType;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for emailaddress
    public String getEmailaddress() {
        return emailaddress;
    }

    // Setter for emailaddress
    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for userType
    public String getUserType() {
        return userType;
    }

    // Setter for userType (not common for arrays like this)
    public void setUserType(String userType) {
        this.userType = userType;
    }
}
