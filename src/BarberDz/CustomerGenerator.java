/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;

import java.util.Random;
import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class CustomerGenerator implements Runnable {
    private int sleep;
    private BarberShop barberShop;

    // відает листами по 2-3 человека 
    // Напрямую в очередь 
    // Проверяет есть мества в очереди не проверяет 
    // Если у клинетов меньше мест в очреди их удаляют 
    // Логика возраст у клиента клиента 
    // Нужно прописать логику. 
    // Промежутки времени System 
    public CustomerGenerator(BarberShop shop) {
        this.barberShop = shop;
    }
    
    public void run() {
        Customer temp = null;
       
        int c = 4 - new Random().nextInt(2);
        try {
            System.out.println(" Генератор клиентов начал работать");
            
            while (true) {  
               
                
                List<Customer> customerList = new ArrayList<>();
                int z = 4 - new Random().nextInt(2) - new Random().nextInt(1);
                for (int y = 0; y < z; y++) {
                    if (y == 0) {
                        temp = new Customer(new Random().nextInt(45) + 18);
                        System.out.println("Генератор произвел клиента: age " + temp.getAge());
                        customerList.add(temp);
                    }
                    temp = new Customer(new Random().nextInt(45));
                    System.out.println("Генератор произвел клиента: age " + temp.getAge());
                    customerList.add(temp);
                }
                boolean bol = barberShop.setCustomer(customerList);
                String str = bol?"Клиенты были добавлены удачно в количестве " + customerList.size():"Клиенты не были добавлены в очередь ";
                System.out.println(str);
                customerList = null;
                Thread.sleep(1000);
            }            
        } catch (Exception e) {
            
        }
    }
    
}
