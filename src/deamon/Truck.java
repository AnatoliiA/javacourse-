/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deamon;


import java.util.HashSet;
import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class Truck implements Runnable {

    private int front;
    private int back;
    private String name;
    private Car[] carstoc = new Car[8];
    private List<Parking> parkings = new ArrayList<>();
    private Ship ship;
    private int count;

    public Truck(String name) {
        this.name = name;
    }

    public void setparking(Parking parking) {
        parkings.add(parking);
    }

    public void setship(Ship ship) {
        this.ship = ship;
    }

    public void setcar(Car car) {
        if (getBack() == carstoc.length) {
            if (carstoc[getBack() - 1] != null) {
                System.out.println("У паркинга не забрали еще ранее произвденные машины");
                return;
            }
        }
        System.out.println(" прием front " + getFront() + " back " + getBack());
        carstoc[getBack()] = car;
        System.out.println("паркиг " + name + " " + this.hashCode() + " принял машину " + getBack());
        back++;
    }

    public boolean isHasEmptyPlace() {
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                return false;
            }
        }
        return true;
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

    public int countEmptyPlace() {
        int z = 0;
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                z++;
            }
        }
        return z;
    }

    public int countCarParkings() {
        int count = 0;
        for (Parking p : parkings) {
            count += p.cuntFullPlace();
        }
        return count;
    }

    private int size() {
        return getBack() - getFront();
    }

    public Car uploadToShip() {
        if (size() == 0) {
            System.out.println(" ___ трак отдал все машины ждите нового производства ____");
            return null;
        }
        Car car = carstoc[getFront()];
        carstoc[getFront()] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        return car;
    }

    private void printQueue() {
        for (int i = getFront(); i < getBack(); i++) {
            System.out.println(" quee Car " + i + " " + carstoc[i]);
        }
    }

    public int getParkingFullCount() {
        List<Parking> parkingt = new ArrayList<>();
        int ep = 0;
        for (int y = 0; y < parkings.size(); y++) {
            ep += parkings.get(y).cuntFullPlace();
        }
        return ep;
    }

    @Override
    public String toString() {
        return "Трак";
    }

    @Override
    public void run() {
            if ((front == 0 && back == 0) || back != 8 || countCarParkings() > 7) {
                System.out.println(" Трак принимает машины есть сводные места" + this.countEmptyPlace() + " в паркингах машин " + countCarParkings());
                do {
                    for (Parking parking : parkings) {
                        for (int y = 0; y < parking.cuntFullPlace(); y++) {
                            if (parking.isEmpty()) {
                                break;
                            }
                            Car car = parking.uploadToTruck();
                            if (car == null || back == 8) {
                                break;
                            }
                            this.setcar(car);
                            System.out.println(" Машина " + car + " загружена в трак " + name + " из паркинга " + parking.toString()
                                      + "\n машин в паркинге осталось " + parking.cuntFullPlace() + "\n не заполненых мест в траке осталось " + this.countEmptyPlace());
                            count--;
                        }
                    }
                } while (this.isHasEmptyPlace());
            }

            if (ship.isHasEmptyPlace() && isFull()) {
                System.out.println("front " + front);
                do {
                    Car car = uploadToShip();
                    if (car == null) {
                        System.out.println(" машина пуста ");
                        break;
                    };
                    try {
                        ship.getFromTruck(car);
                    } catch (MyException e) {
                        System.out.println(" машина " + car + " выгружена на склад так имеет двойника ");
                        e.printStackTrace();
                    }
                    System.out.println(" Машина выгружена из трака  " + ship.getName()
                              + "\n машин в траках осталось " + this.countFullPlace()
                              + "\n не заполненых мест в корабле осталось "
                              + ship.countEmptyPlace());
                } while (front != 0 && ship.isHasEmptyPlace());
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
        
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
