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
public class Candy extends Food{
    private String name;
    public Candy(double price, String brand) {
        super(price, 36);
        this.name = brand;
    }
    
    @Override
    public String toString() {
        return  "Конфеты " + this.getName() +  " " + super.toString();
    };

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
