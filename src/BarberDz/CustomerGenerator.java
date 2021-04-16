
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;

import java.util.Random;
import java.util.*;
import java.text.NumberFormat;
/**
 *
 * @author Kamarali Anatolii
 */
public class CustomerGenerator extends Thread {

    private static int counter;
    private String name;
    private int sleep;
    private BarberShop barberShop;
    private int tmin;
    private int tmax;

    // відает листами по 2-3 человека 
    // Напрямую в очередь 
    // Проверяет есть мества в очереди не проверяет 
    // Если у клинетов меньше мест в очреди их удаляют 
    // Логика возраст у клиента клиента 
    // Нужно прописать логику. 
    // Промежутки времени System 
    
    public CustomerGenerator(BarberShop shop, int z, int y, String name) {
        this.setDaemon(true);
        this.barberShop = shop;
        this.tmin = z;
        this.tmax = y;
        this.name = name;
    }

    public void run() {
        Customer temp = null;
        try {
            System.out.println(" Генератор клиентов " + name + " is working ");
            while (true) {
                String[] arrl = {"Masha", "Luba", "Kira", "Karina"};
                List<Customer> customerList = new ArrayList<>();
                for (int ii = 0; ii < new Random().nextInt(3) + 1; ii++) {
                    customerList.add(new Customer(new Random().nextInt(15) + 15, arrl[new Random().nextInt(4)]));
                    System.out.println(" Добавлен клиент " + customerList.get(ii) + " ");
                }
                counter += customerList.size();
                System.out.println(" всего сгенерировано клиентов " + counter);
                barberShop.setCustomer(customerList, this.hashCode());
                Thread.sleep(500 + tmax * 100);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    /**
     * @return the counter
     */
    public static int getCounter() {
        return counter;
    }

}
