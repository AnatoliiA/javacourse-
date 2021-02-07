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
public class Banan extends Food{
    private String name = "Banan";
    public Banan(double price) {
        super(price, 1);
    }
    
     @Override
    public String toString() {
        return  "Продукт " + this.getName() +  " " + super.toString();
    };

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
