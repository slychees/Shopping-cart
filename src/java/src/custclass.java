/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Sly Cheese
 */
public class custclass {
    private String country;
    private String fname;
    private String lname;
    private String address;
    private String city;
//    private int price;
    private String state;
    private String zip;
    private String phone;
    private String email;
//    private int itempurchased;
    private String itempurchased;
    private String quantity;
    private String price;
    private String totalprice;
    
    public custclass(String country, String fname, String lname, String address, String city, String state, String zip, String phone, String email, String itempurchased, String quantity, String price, String totalprice){
        this.country = country;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.itempurchased = itempurchased;
        this.quantity = quantity;
        this.price = price;
        this.totalprice = totalprice;
    }
    
    public custclass(){
        
    }
    
    public String getCountry(){
        return country;
    }
    
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    
    public String getZip(){
        return zip;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getItempurchased(){
        return itempurchased;
    }
    public String getQuantity(){
        return quantity;
    }
    public String getPrice(){
        return price;
    }
    public String getTotalprice(){
        return totalprice;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public void setFname(String fname){
        this.fname = fname;
    }
    
    public void setLname(String lname){
        this.lname = lname;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setState(String state){
        this.state = state;
    }
    public void setZip(String zip){
        this.zip = zip;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
        
    }
    
    public void setEmail(String email){
        this.email = email;
        
    }    
    public void setItempurchased(String itempurchased){
        this.itempurchased = itempurchased;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setTotalprice(String totalprice){
        this.totalprice = totalprice;
    }
}
