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
public class Ship {

    private String name;
    private Truck truck;
    private ToyBoat boat;
    private Car[] cars = new Car[16];

    public Ship(String name) {
        this.name = name;
    }

    public boolean isHasEmptyPlace() {
        for (int u = 0; u < cars.length; u++) {
            if (cars[u] == null) {
                return true;
            }
        }
        return false;
    }

    public int countEmptyPlace() {
        int z = 0;
        for (int u = 0; u < cars.length; u++) {
            if (cars[u] == null) {
                z++;
            }
        }
        return z;
    }

    public int countFullPlace() {
        int z = 0;
        for (int u = 0; u < cars.length; u++) {
            if (cars[u] != null) {
                z++;
            }
        }
        return z;
    }

    public boolean isFull() {
        for (int u = 0; u < cars.length; u++) {
            if (cars[u] == null) {
                return false;
            }
        }
        return true;
    }

    public synchronized void removeCars() {
        for (int u = 0; u < cars.length; u++) {
            cars[u] = null;
        }
    }

    public synchronized void getFromTruck(Car car) throws MyException {
        for (int u = 0; u < cars.length; u++) {
            if (cars[u] != null) {
                if (cars[u].getSerialnumber().equals(car.getSerialnumber())) {
                    throw new MyException("Машина с таким серийный номером уже есть");
                }
            }
        }
        if (isHasEmptyPlace()) {
            for (int u = 0; u < cars.length; u++) {
                if (cars[u] == null) {
                    System.out.println("Корбаль  принял машину  c  " + car);
                    cars[u] = car;
                    return;
                }
            }
        } else {
            System.out.println(" нет совбодных мест ");
        }
    }

    @Override
    public String toString() {
        return " корабль по имени " + getName();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
