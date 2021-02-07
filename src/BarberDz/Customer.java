/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;
import java.util.*;
/**
 *
 * @author Kamarali Anatolii
 */
public class Customer {
    private long entance;
    private int age;
    /**
     * @return the entance
     */
    public long getEntance() {
        return entance;
    }
   
    
    public Customer(int age){
        this.age = age;
    
    }
    public void setEntrance(){
      this.entance = System.currentTimeMillis();
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
}
