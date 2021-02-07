/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synBlock;

import BarberDz.Printer;

/**
 *
 * @author Kamarali Anatolii
 */
public class Person extends Thread {

    private String name;
    private Printer printer;

    public Person(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
        // синхронизированній блок synchronized
        synchronized (printer) {
            for (int i = 0; i < 10; i++) {
                printer.print("" + i + " " + name);
                try {
                    this.sleep(100);
                } catch (Exception e) {

                }
                printer.print(" ->" + i + " " + name + " \n");
            }
        }

    }

}
