/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import sun.security.pkcs11.wrapper.CK_DESTROYMUTEX;

/**
 *
 * @author Kamarali Anatolii
 */
enum Material{GOLD, SILVER, CUPRUM, CHROM, NOMETAL};



public abstract class Jewerly extends Product {
    public Material material;
    public float metalweigth;
    public boolean iSstone;
    public String articul;
    
    public Jewerly(double price, boolean  isStonne, String articul) {
        super(price);
        this.iSstone = isStonne;
        this.articul = articul;
    }
    
    public void setVarJewerly(Material material){
        this.material = material;
    };
    
     public Material getMaterial(){
           return this.material;
     };
    
     public boolean isStone(){
         return this.iSstone;
     }
    
     @Override
     public String toString(){
          return "Артикул изделия " + this.articul + " Изделие изготовлена из: " + material;
     }
}
