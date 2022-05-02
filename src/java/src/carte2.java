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
public class carte2 {
    private String image;
    private  String productname;    
    private float price;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the name
     */
    public String getProductName() {
        return productname;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.productname = name;
    }

    /**
     * @return the author
     */
    public String getImage() {
        return image;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String img) {
        this.image = img;
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
}
