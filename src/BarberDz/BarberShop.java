/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;

import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class BarberShop {
    // Создать статистические пе
    // Сколько пришло в барбер шоп 
    // Количество обслуженых клиентов.
    // Среднее время ожидание в очереди 
    // Среднее время каждого барбера 
    // Среденее время всех барберов
    
    private int leavewithoutservice; 
    private Printer printer;
    private Queue que;

    public BarberShop(Printer printer) {

        this.que = new Queue();
        this.printer = new Printer();

    }

    public synchronized boolean setCustomer(List<Customer> cl) {
        wait();
        System.out.println("Генератор передал клиентов в очередь: age " + cl.size());
        return que.setCustomerList(cl);
    }

    public boolean isFull() {
        return que.isFull();
    }

    public class Queue {
        // Метод в 
        private Destructor dest;
        private List<Customer> customers = new CustomArrayList();

        public Queue() {
            Thread destr = new Thread(new Destructor());
            destr.setDaemon(true);
            destr.start();
        }

        public void delete() {
        }

        public void set(Customer client) {

        }
        // Сколько клиентов в очереди 
        // в аррей листе нет нул 
        
        public long getCountEmpty() {
            return customers.stream().filter(x -> x == null).count();
        }

        public long getCountFull() {
            return customers.stream().filter(x -> x != null).count();
        }

        public boolean isFull() {
            return customers.size() == customers.stream().filter(x -> x != null).count();
        }

        public synchronized boolean setCustomerList(List<Customer> cl) {
            System.out.println("Queue gets clients quantity " + cl.size());
            int count = (int) cl.stream().filter(x -> x.getAge() < 18).count();
            long total = cl.size();
            long ce = getCountEmpty();
            System.out.println("Queue has the kids " + count
                      + " total clients quantity " + total
                      + " пустых мест в очереди " + ce);
            if (ce >= total) {
                System.out.println(" Добавление клиентов + " + total + " в очередь  было " + que.getCountFull());
                cl.stream().forEach(x -> customers.add(x));
                System.out.println(" Добавление клиентов + " + total + " стало " + que.getCountFull());
                return true;
            } else {
                switch (count) {
                    case 0:
                        for (int z = 0; z < total; z++) {
                            customers.add(cl.get(z));
                        }
                        break;
                    default:
                        cl.clear();
                        return false;

                }

            }

            return true;
        }

        public boolean isEmpty() {
            return customers.isEmpty();
        }

        public Customer getClient() {
            return customers.remove(0);
        }

        private class Destructor implements Runnable {

            @Override
            public void run() {
                System.out.println(" Запущен деструктор ");
                while (true) {
                    for(int r = customers.size()-1; r >= 0;r--){
                       if(System.currentTimeMillis() - customers.get(r).getEntance() > 2000){
                           // Описасть здесь 
                           customers.remove(r);
                       }
                    
                    }
//                    customers.removeIf(x -> System.currentTimeMillis() - x.getEntance() > 2000);
                    
                       
                    }
                }

            }

        }
    }

    public class Barber {
        // Создать переменную сколько удачно обсужилось 
        // 
        private long timerest;

    }

}
