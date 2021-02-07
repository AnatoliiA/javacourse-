/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Kamarali Anatolii
 */
public class Boat extends Vehicle_swming{
    private int oar;
    public Boat() {
        super(4000, 10.0, 5, FUEL.GAS, 10);
        this.oar = 2;
    }
    
}
