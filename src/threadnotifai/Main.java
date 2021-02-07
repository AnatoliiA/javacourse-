/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadnotifai;


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
        sumsungtr.start();
        Producer apple = new Producer(shop, Manifactor.APPALE, printer);
        Thread appleThread = new Thread(apple);
        appleThread.start();
        Client vasya = new Client(shop, printer, "Vasya", 21);
        Thread vasyaThread = new Thread(vasya); 
        vasyaThread.start();
        Client petya = new Client(shop, printer, "Petya", 21);
        Thread petyaThread = new Thread(petya);
        petyaThread.start();
        try {
            sumsungtr.join();
            appleThread.join();
            vasyaThread.join();
            petyaThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // зарывития
        printer.closebuffed();
    }
}
