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
public abstract class Vehicle_swiming_deep extends Vehicle_swming{
    private int deepmax;
    private boolean isDeep;
    
    public Vehicle_swiming_deep() {
        super(100, 50.0, 5000, FUEL.ELECTRIC, 100);
        this.deepmax = deepmax;
    }

    /**
     * @return the isDeep
     */
    public boolean isIsDeep() {
        return isDeep;
    }

    /**
     * @param isDeep the isDeep to set
     */
    public void setIsDeep(boolean isDeep) {
        this.isDeep = isDeep;
    }
    
}
