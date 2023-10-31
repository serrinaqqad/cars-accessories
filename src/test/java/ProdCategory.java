/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class ProdCategory {
    private String Name;
    private String Description;
    
    public String getName() {
        return Name;
    }

    public void setName(String Category_name) {
        this.Name = Category_name;
    }
    
    public String getDesc() {
        return Description;
    }

    public void setDesc(String Category_description) {
        this.Description = Category_description;
    }
    
    public ProdCategory(String name, String description){
        this.Name = name;
        this.Description = description;
    }
    public ProdCategory(){
    }
}
