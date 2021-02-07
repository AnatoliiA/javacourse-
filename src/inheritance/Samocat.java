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
public class Samocat extends Vehicle {
    private int wheels;
    private int agefrom;
    private int agetill;
     
    /**
     *
     * @param wheels
     * @param run
     */
    public Samocat(int run, double  speed, int wheels){
      super(run, speed);
        while (wheels > 3) {            
            System.out.println("У самоката максимальное количество колес 3");
            wheels = 3;
        }
      this.wheels = wheels;
    }

    /**
     * @return the wheel
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * @return the agefrom
     */
    public int getAgefrom() {
        return agefrom;
    }

    /**
     * @return the agetill
     */
    public int getAgetill() {
        return agetill;
    }
}
