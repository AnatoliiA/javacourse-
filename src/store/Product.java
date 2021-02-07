/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author Kamarali Anatolii
 */
public abstract class Product {
    // модификатор доступа к полю делает видимым все всем наледникам
    protected double price;
    
    public Product(double price){
        this.price = price;
    }
    
    public void setPrice(double price){
      this.price = price;
    } 
    
     public double getPrice(){
       return this.price;
    } 
     
}
