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
public class Main {

    public static void main(String[] args) {
        // синхронизационный блок
        // синхронизационный метод 
        Printer printer = new Printer();
        Person vasay = new Person("Vasay", printer);
        vasay.start();
        Person petr = new Person("Pert", printer);
        petr.start();
        Person vlad = new Person("Vlad", printer);
        vlad.start();
        try {
            vasay.join();
            petr.join();
            vlad.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        printer.closebuffed();
    }
}
