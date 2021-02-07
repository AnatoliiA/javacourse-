/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadparkin;

/**
 *
 * @author Kamarali Anatolii
 */
public class Ship {

    private int back = 0;
    private int front = 0;
    private String name;
    private Truck truck;
    private PackHouse boat;
    private Car[] carstoc = new Car[16];
    private Printer printer;

    public Ship(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    public boolean isHasEmptyPlace() {
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                return true;
            }
        }
        return false;
    }

    public int countEmptyPlace() {
        int z = 0;
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                z++;
            }
        }
        return z;
    }

    public int countFullPlace() {
        int z = 0;
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] != null) {
                z++;
            }
        }
        return z;
    }

    public boolean isFull() {
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                return false;
            }
        }
        return true;
    }

    public synchronized void removeCars() {
        for (int u = 0; u < carstoc.length; u++) {
            carstoc[u] = null;
            String str = "Буксир отбуксировал машину " + carstoc[u] + " ";
            System.out.println(str);
            synchronized (printer) {
                printer.print(str);
            }
        }
        front = 0;
        back = 0;
    }

    public synchronized void setFromTruck(Car car) throws MyException {
        if (back == carstoc.length) {
            if (carstoc[getBack() - 1] != null) {
                System.out.println("Корабль полон забрали еще ранее произвденные машины");
                throw new MyException("Корабль полон забрали еще ранее произвденные машины");
            }
        }
        for (int u = front; u < back; u++) {
            if (carstoc[u] != null) {
                if (carstoc[u].getSerialnumber().equals(car.getSerialnumber())) {
                    throw new MyException("Машина с таким серийный номером уже есть");
                }
            }
        }
        carstoc[back] = car;
        String str = "Корабль принял машину " + carstoc[back] + " ";
        System.out.println(str);
        synchronized (printer) {
            printer.print(str);
        }
        back++;

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

    /**
     * @return the back
     */
    public int getBack() {
        return back;
    }

    /**
     * @return the front
     */
    public int getFront() {
        return front;
    }

}
