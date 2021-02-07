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
public abstract class Vehicleng_with_wheel extends Vehiclewithengine{
    private int wheel;
    
    public Vehicleng_with_wheel(int resurs, double speed, int enginepower, FUEL fuel, int wheel ) {
        super(resurs, speed, enginepower, fuel);
        this.wheel = wheel;
    }

    /**
     * @return the wheel
     */
    public int getWheel() {
        return wheel;
    }
    
}
