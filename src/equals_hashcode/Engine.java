/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equals_hashcode;

/**
 *
 * @author Kamarali Anatolii
 */
public class Engine {
    private String brand;
    private int power;
    private double volume;
    
    public Engine(String brand, int power, double volume){
         this.brand = brand;
         this.power = power;
         this.volume = volume;
    }
    @Override
    public boolean equals(Object object){
      if (this == object) return true;
      if (object == null) return false;
      if (!(object instanceof Engine)) return false;
      Engine engine = (Engine) object;
      // нужно проверять обьекты а не свовойства объекта
      return this.brand.equals(engine.brand) && this.power == engine.power 
         && this.volume == engine.volume;
    }
    
    @Override
    public int hashCode() {
        int hashcode = 13;
        hashcode = 13 * hashcode + brand.hashCode();
        hashcode = 13 * hashcode + this.power;
        hashcode = 13 * hashcode + Double.hashCode(volume);
        return hashcode;
    }

    
    
    
    
    
    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @return the volume
     */
    public double getVolume() {
        return volume;
    }
    
    
    
}
