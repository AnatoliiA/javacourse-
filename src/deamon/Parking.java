/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deamon;

import java.util.List;

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
    private boolean isUsedByManifactor;

    public Parking(String name) {
        this.name = name;
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

    public int cuntFullPlace() {
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

    public synchronized Car uploadToTruck() {
        try {
            if (size() == 0) {
                System.out.println(" ___ паркинг отдал все машины ждите нового производства ____");
                return null;
            }
        } catch (Exception e) {
            System.out.println(" произошла ошибка " + front);
        }
        
        //printQueue();
        System.out.println(" отдача  front " + front + " back " + back);
        Car car = carstoc[front];
        carstoc[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        return car;
      //  notifyAll();
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
        try {
            if (back == carstoc.length) {
                if (carstoc[back - 1] != null) {
                    System.out.println("У паркинга не забрали еще ранее произвденные машины");
                    wait();
                }
            }
          
            // System.out.println(" прием front " + front + " back " + getBack());
            carstoc[back] = car;
            System.out.println("паркиг " + name + " " + this.hashCode() + " принял машину " + carstoc[getBack()]);
            back++;
            notifyAll();
        } catch (Exception e) {
        }

    }

    @Override
    public String toString() {
        return " паркинга " + this.getName();
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
