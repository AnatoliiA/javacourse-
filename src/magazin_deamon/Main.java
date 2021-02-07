/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazin_deamon;


import java.io.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Shop shop = new Shop(printer);
        Producer samsung = new Producer(shop, Manifactor.SAMSUNG, printer);
        Thread sumsungtr = new Thread(samsung);
        sumsungtr.setDaemon(true);
        sumsungtr.start();
        Producer apple = new Producer(shop, Manifactor.APPALE, printer);
        Thread appleThread = new Thread(apple);
        appleThread.setDaemon(true);
        appleThread.start();
        Client vasya = new Client(shop, printer, "Vasya", 21);
        Thread vasyaThread = new Thread(vasya);
        vasyaThread.setDaemon(true);
        vasyaThread.start();
        Client petya = new Client(shop, printer, "Petya", 21);
        
        Thread petyaThread = new Thread(petya);
        petyaThread.setDaemon(true);
        petyaThread.start();
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // зарывития
        printer.closebuffed();
    }
}
