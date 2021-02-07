/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadparkin;

import java.util.HashSet;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Kamarali Anatolii
 */
public class Truck implements Runnable {

    private Printer printer;
    private int front;
    private int back;
    private String name;
    private Car[] carstoc = new Car[8];
    private List<Parking> parkings = new ArrayList<>();
    private Ship ship;
    private int count;
    private PackHouse packhouse;

    public Truck(String name, PackHouse packHouse, Printer printer) {
        this.name = name;
        this.packhouse = packhouse;
        this.printer = printer;
    }

    public void setparking(Parking parking) {
        parkings.add(parking);
    }

    public void setship(Ship ship) {
        this.ship = ship;
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

    public synchronized int countCarParkings() {
        int count = 0;
        for (Parking p : parkings) {
            count += p.countFullPlace();
        }
        return count;
    }

    private int size() {
        return getBack() - getFront();
    }

    public synchronized void setcar(Car car) {
        if (getBack() == carstoc.length) {
            if (carstoc[getBack() - 1] != null) {
                System.out.println("У паркинга не забрали еще ранее произвденные машины");
                return;
            }
        }
        carstoc[back] = car;
        String str = "трак " + name + " принял машину  на место " + back + " " + car;
        System.out.println(str);
        synchronized (printer) {
            printer.print(str);
        }
        back++;
    }

    public synchronized List<Car> uploadToShip() {
        List<Car> list = new ArrayList<>();
        if (size() == 0) {
            System.out.println(" ___ трак отдал все машины ждите нового производства ____");
            return null;
        }
        int z = ship.countEmptyPlace();
        int check = (back - front) - z;
        if (check == 0 || check < 0) {
            list = Arrays.asList(carstoc).stream().filter(x -> x != null).collect(Collectors.toList());
            carstoc = new Car[8];
            front = 0;
            back = 0;
        } else {
            for (int s = front; s < front + z; s++) {
                list.add(carstoc[s]);
                carstoc[s] = null;
            }
            front = front + z;
        };
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        return list;
    }

    private void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(" quee Car " + i + " " + carstoc[i]);
        }
    }

    public int getParkingFullCount() {
        List<Parking> parkingt = new ArrayList<>();
        int ep = 0;
        for (int y = 0; y < parkings.size(); y++) {
            ep += parkings.get(y).countFullPlace();
        }
        return ep;
    }

    @Override
    public String toString() {
        return "Трак";
    }

    @Override
    public void run() {
        count = 80;
        while (count > 0) {
            int ccp = countCarParkings();
            if ((front == 0 && back == 0) && back != 8 && ccp > 7) {
                int cept = this.countEmptyPlace();
                System.out.println(" Трак принимает машины есть сводные места " + cept + " в паркингах машин " + countCarParkings());
                for (Parking parking : parkings) {
                    if (parking.countFullPlace() == 0) {
                        continue;
                    }
                    if (isFull()) {
                        break;
                    }
                    List<Car> cars = parking.uploadToTruck(this.countEmptyPlace());
                    for (Car car : cars) {
                        this.setcar(car);
                        int cep = parking.countFullPlace();
                        String str = " Машина " + car + " загружена в трак " + name + " из паркинга " + parking.toString()
                                  + "\n машин в паркинге осталось " + cep + "\n не заполненых мест в траке осталось " + this.countEmptyPlace();
                        System.out.println(str);
                        synchronized (printer) {
                            printer.print(str);
                        }
                    }
                    count = count - cars.size();
                }

            }

            if (ship.isHasEmptyPlace() && isFull()) {
                do {
                    if (ship.isFull()) {
                        break;
                    }
                    List<Car> carship = uploadToShip();
                    Car cart = null;
                    try {
                        for (Car car : carship) {
                            cart = car;
                            ship.setFromTruck(car);
                            int ftk = countFullPlace();
                            int esh = ship.countEmptyPlace();
                            String str = " Машина " + car + " загружена в корабль " + car.getName() + " из  трака " + name
                                      + "\n машин в траке осталось " + ftk + "\n не заполненых мест в кораболк осталось " + esh;
                            System.out.println(str);
                            synchronized (printer) {
                                printer.print(str);
                            }
                        }
                    } catch (MyException e) {
                        String str = " машина " + cart + " выгружена на склад так имеет двойника ";
                        System.out.println(str);
                            synchronized (printer) {
                                printer.print(str);
                            }
                        packhouse.setCat(cart);
                        e.printStackTrace();
                    }
                } while (front != 0 && ship.isHasEmptyPlace() && countFullPlace() > 0);
            }
            try {
            Thread.sleep(300);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
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
