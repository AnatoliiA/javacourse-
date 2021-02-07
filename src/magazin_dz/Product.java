/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazin_dz;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.*;
/**
 *
 * @author Kamarali Anatolii
 */
public class Product {
    private int countparts;
    private Manifactor brand;
    private double price;
    private Manifactor manufactor;
    private long sn;
              
              
    public Product(Manifactor manifactor, int sn) {
        this.brand = manifactor;
        this.sn = sn;
    }

    
    /**
     * @return the brand
     */
    public Manifactor getBrand() {
        return brand;
    }


    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(Manifactor brand) {
        this.brand = brand;
    }

    /**
     * @param manufactor the manufactor to set
     */
    public void setManufactor(Manifactor manufactor) {
        this.manufactor = manufactor;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the countparts
     */
    public int getCountparts() {
        return countparts;
    }

    /**
     * @return the sn
     */
    public long getSn() {
        return sn;
    }

    /**
     * @param countparts the countparts to set
     */
    public void setCountparts(int countparts) {
        this.countparts = countparts;
    }

    /**
     * @param sn the sn to set
     */
    public void setSn(long sn) {
        this.sn = sn;
    }

    
    @Override
    public String toString(){
      return " имя продукта " + brand.name() + " серийный номер продукта " + sn + " цена " + brand.getPrice();
    }
}
