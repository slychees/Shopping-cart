/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author nazaraf
 */public class Carte {
    private int productid;
    private  String name ;
    private String category;
    private float price;
    private int quantity;
    private int itemp;

    
    public int getproductid() {
        return productid;
    }

    /**
     * @param productid the name to set
     */
    public void setproductid(int productid) {
        this.productid = productid;
    }
    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the author
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
        
    /**
     * @return quantity the name to set
     *
     */
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }    
    
     public int getItemp() {
        return itemp;
    }

    public void setItemp(int itemp) {
        this.itemp = itemp;
    }    
}
