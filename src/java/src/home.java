/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

public class home {
    private String productid;
    private String productname;
    private String category;
    private String quantity;
    private int price;
    private String description;
    private String image;
    
    public home(String productid, String productname, String category, String quantity, int price, String description, String image){
        this.productid = productid;
        this.productname = productname;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
    }
    
    public home(){
        
    }
    
    public String getProductid(){
        return productid;
    }
    
    public String getProductname(){
        return productname;
    }
    public String getCategory(){
        return category;
    }
    public String getQuantity(){
        return quantity;
    }
    public int getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    
    public String getImage(){
        return image;
    }
    
    public void setProductid(String productid){
        this.productid = productid;
    }
    
    public void setProductname(String productname){
        this.productname = productname;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setImage(String image){
        this.image = image;
        
    }
}
