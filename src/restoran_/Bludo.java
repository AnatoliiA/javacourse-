/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran_;

/**
 *
 * @author Kamarali Anatolii
 */
public class Bludo {

    private String name;
    private double colories;
    private int weigth;
    private double price;

    public Bludo(String name, Double colories, int weigth) {
        this.colories = colories;
        this.weigth = weigth;
        this.name = name;
    }

    /**
     * @return the colories
     */
    public double getColories() {
        return colories;
    }

    @Override
    public String toString() {
        return name + " вес " + weigth + " колорийность " + colories;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the weigth
     */
    public int getWeigth() {
        return weigth;
    }

    /**
     * @param colories the colories to set
     */
    public void setColories(double colories) {
        this.colories = colories;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param weigth the weigth to set
     */
    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
