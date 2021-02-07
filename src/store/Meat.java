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
enum MEATS{CHIKEN,  BEEF, PORK, HOURSE, MIXT};

public class Meat extends Food{
    private MEATS sort;
    public Meat(double price, MEATS meats) {
        super(price, 1);
        this.sort = meats;
    }
    
     @Override
    public String toString() {
        return  "Продукт мясо " + this.getSort() +  " " + super.toString();
    };

    /**
     * @return the sort
     */
    public String getSort() {
        return this.sort.toString();
    }

    /**
     * @return the name
     */
   
}
