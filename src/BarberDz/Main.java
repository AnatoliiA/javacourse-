
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
        BarberShop barberShop = new BarberShop(printer, 3);
        Thread street = new Thread(new CustomerGenerator(barberShop,3, 4 ,"street"));
        Thread shop = new Thread(new CustomerGenerator(barberShop,3, 4 ,"shop"));
        Thread market = new Thread(new CustomerGenerator(barberShop,3, 4 ,"market"));
        street.start();
        shop.start();
        market.start();
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
              
}
