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
public class Ring extends Jewerly {
    private double  diametr;
    public Ring(double price, boolean isStonne, double diametr, String articul) {
        super(price, isStonne, articul);
        this.diametr = diametr;
    }

    @Override
    public String toString() {
        return super.toString() + " Диаметр изделия " + this.diametr + " \n"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
