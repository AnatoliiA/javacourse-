/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equals_hashcode;

import java.util.Date;

/**
 *
 * @author Kamarali Anatolii
 */
public class Car {

    private String brand;
    private String model;
    private String number;
    private String owner;
    private long vinNumber;
    private Engine engine;
    private double price;
    private Date date;

    private int doors;

    // конструктор 
    public Car(String brand, String model, long number, int doors, Date date) {
        this.brand = brand;
        this.model = model;
        this.vinNumber = number;
        this.doors = doors;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Бренд машины" + this.getBrand() + " модель машины " + this.model + " vin " + this.vinNumber
                + " дата выпуска " + this.getDate();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        // нужно проверять обьекты а не свовойства объекта
        boolean isengane = false;
        if (this.getEngane() == null && car.getEngane() == null) {
            isengane = true;
        } else if (this.getEngane() == null && car.getEngane() != null) {
            isengane = false;
        } else if (this.getEngane() != null && car.getEngane() == null) {
            isengane = false;
        } else {
            isengane = true;
        }

        return this.brand.equals(car.brand) && this.vinNumber == car.vinNumber
                && this.date.equals(car.date) && isengane && this.engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        int hashcode = 13;
        hashcode = 13 * hashcode + brand.hashCode();
        hashcode = 13 * hashcode + model.hashCode();
        hashcode = 13 * hashcode + Long.hashCode(vinNumber);
        hashcode = 13 * hashcode + this.doors;
        hashcode = 13 * hashcode + this.date.hashCode();
        hashcode =  this.engine == null? hashcode: hashcode*13 + this.engine.hashCode();
        return hashcode;
    }

    public String getBrand() {
        return this.brand;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the doors
     */
    public int getDoors() {
        return doors;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the vinNumber
     */
    public long getVinNumber() {
        return vinNumber;
    }

    /**
     * @param engine the engine to set
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngane() {
        return engine;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
