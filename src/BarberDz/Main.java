/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;

/**
 *
 * @author Kamarali Anatolii
 */
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        BarberShop barberShop = new BarberShop(printer);
        CustomerGenerator generator = new CustomerGenerator(barberShop);
        Thread tread = new Thread(generator);
        tread.setDaemon(true);
        tread.start();
        try {
            Thread.sleep(300000);
        } catch (Exception e) {
        }
        
    }
              
}
