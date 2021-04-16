/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;

import java.util.*;
import java.text.NumberFormat;
/**
 *
 * @author Kamarali Anatolii
 */
public class Customer {
    private DebugClass db = new DebugClass();
    private int model = new Random().nextInt(4);
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    /**
     * @return the name
     */

    public String getName() {
        return name;
    }
    private long entance;
    private int age;
    private String name;

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public long getEntance() {
        return entance;
    }

    public void setEntrance() {
        this.entance = System.currentTimeMillis();
        db.printDebug( " клиент получил время входа в очредб " + this.entance);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        String sttr;      
        sttr = this.entance==0?"":" время от входа в очередь " + (double)((System.currentTimeMillis() - this.entance) / 1000.0);
        return "  клиент " + this.name + " возраст " + this.age + " тип стрижки клиента " + getModel() + sttr;
    }

    /**
     * @return the model
     */
    public int getModel() {
        return model;
    }
}
