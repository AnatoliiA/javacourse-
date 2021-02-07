/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadparkin;

import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class PackHouse {

    private String name;
    private ArrayList<Car> cars = new ArrayList<>();
    Printer printer;

    public PackHouse(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    public void setCat(Car car) {
        String str = "cклад  " + name + " принял машину " + car;
        System.out.println(str);
        synchronized (printer) {
            printer.print(str);
        }
        cars.add(car);
    }
}
