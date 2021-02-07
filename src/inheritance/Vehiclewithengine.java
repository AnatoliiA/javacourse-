/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;
enum FUEL{GAS, DISEL, GASOLINE, ELECTRIC}
/**
 *
 * @author Kamarali Anatolii
 */
public abstract class Vehiclewithengine extends Vehicle{
    private int enginepower;
    private FUEL fuel;
    /**
     *
     * @param run
     */
    public Vehiclewithengine(int resurs, double speed, int enginepower, FUEL fuel) {
        super(resurs, speed);
        this.enginepower = enginepower;
        this.fuel = fuel;
    }

    /**
     * @return the enginepower
     */
    public int getEnginepower() {
        return enginepower;
    }

    /**
     * @param enginepower the enginepower to set
     */
    public void setEnginepower(int enginepower) {
        this.enginepower = enginepower;
    }
    
    
    
}
