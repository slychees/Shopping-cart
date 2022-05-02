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
public class item {
    private home item;
    private int quantity;
    private int itemid;
    private int itemp;
  
    public item(home item, int quantity, int itemid, int itemp){
        this.item = item;
        this.quantity = quantity;
        this.itemid = itemid;
        this.itemp = itemp;
    }
    
    public item(){
        
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public home getItem(){
        return item;
    }
    
    public int getItemid(){
        return itemid;
    }
    
    public int getItemp(){
        return itemp;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setItem(home item){
        this.item = item;
    }
    
    public void setItemid(int itemid){
        this.itemid = itemid;
    }
    public void setItemp(int itemp){
        this.itemp = itemp;
    }
}
