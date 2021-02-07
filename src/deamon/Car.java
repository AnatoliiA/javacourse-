/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deamon;



/**
 *
 * @author Kamarali Anatolii
 */
enum ENGINE{
    DIESEL, GAZOLINE, GAS
}
public class Car {
    private String name;
    private ENGINE engine;
    private String serialnumber;
    
    public Car(int serialnumber, String breand, ENGINE engine){
     this.serialnumber = "" + serialnumber;
     this.name = breand;
     this.engine = engine;
    }

    
    /**
     * @return the engine
     */
    public ENGINE getEngine() {
        return engine;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    // 
    public void setSerial(int a){
      this.serialnumber = Integer.toHexString(a);
    }
   

    /**
     * @param engine the engine to set
     */
    public void setEngine(ENGINE engine) {
        this.engine = engine;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the serialnumber
     */
    public String getSerialnumber() {
        return serialnumber;
    }
    
    @Override
    public String toString(){
       return " машина " + name + " с номер серии  "  + serialnumber;
    }
}
