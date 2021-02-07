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
public class Barbie extends Toy {
        
    public Barbie(Double price, String article) {
        super(price, 2, 8, article);
    }
     
    public String toString(){
      return super.toString();
    }
}
