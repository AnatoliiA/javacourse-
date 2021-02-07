/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadparkin;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Kamarali Anatolii
 */
public class Parking {
// В каждом траке лист перкингов.

    private int back = 0;
    private int front = 0;
    private String name;
    private Car[] carstoc = new Car[6];
    private Printer printer;

    public Parking(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }
//    public boolean isUsed() {
//        return isUsedByManifactor;
//    }
//
//    public void toggleIsUSedByMan() {
//        isUsedByManifactor = !isUsedByManifactor;
//    }

    public int getfront() {
        return front;
    }

    public boolean isHasEmptyPlace() {
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                return true;
            }
        }
        return false;
    }

    public synchronized int countFullPlace() {
        int z = 0;
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] != null) {
                z++;
            }
        }
        return z;
    }

    public int getCountEmpty() {
        int z = 0;
        for (int u = 0; u < carstoc.length; u++) {
            if (carstoc[u] == null) {
                z++;
            }
        }
        return z;
    }

    public synchronized List<Car> uploadToTruck(int z) {
        List<Car> list = new ArrayList<>();
        try {
            if (size() == 0) {
                System.out.println(" ___ паркинг отдал все машины ждите нового производства ____");
                return null;
            }
        } catch (Exception e) {
            System.out.println(" произошла ошибка " + front);
        }

        int check = (back - front) - z;
        if (check == 0 || check < 0) {
            list = Arrays.asList(carstoc).stream().filter(x -> x != null).collect(Collectors.toList());
            carstoc = new Car[6];
            front = 0;
            back = 0;
        } else {
            for (int s = front; s < front + z; s++) {
                list.add(carstoc[s]);
                carstoc[s] = null;
            }
            front = front + z;
        };
        System.out.println(" количестово машин " + check);
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        return list;
    }

    private int size() {
        return back - front;
    }

    private void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(" quee Car " + i + " " + carstoc[i]);
        }
    }

    public boolean isEmpty() {
        boolean bol = true;
        if (back == 0 && front == 0) {
            bol = false;
        }
        return bol;
    }

    public synchronized void setCar(Car car) {
        if (back == carstoc.length) {
            if (carstoc[getBack() - 1] != null) {
                System.out.println("У паркинга не забрали еще ранее произвденные машины");
                return;
            }
        }
        carstoc[back] = car;
        String str = "Паркиг " + name + " " + this.hashCode() + " принял машину " + carstoc[getBack()];
        System.out.println(str);
        synchronized (printer) {
            printer.print(str);
        }
        back++;

    }

    @Override
    public String toString() {
        return "Название  паркинга " + this.getName();
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
}
