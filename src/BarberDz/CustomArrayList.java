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
public class CustomArrayList extends ArrayList<Customer> {

    private int count = 12;

    @Override
    public boolean add(Customer e) {
        if (this.size() < count) {
            return super.add(e);
        }
        // shift
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Customer> c) {
        int line;
        line = this.size() + c.size();
        if (line > 12) {
            return false;
        }
        super.addAll(c);
        return true;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

}
