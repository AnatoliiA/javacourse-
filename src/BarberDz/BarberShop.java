
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberDz;

import java.util.*;
import java.util.logging.Logger;

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
    private static int nonserviceclient;
    private static int nonqueclient;
    private static int countallbarber;
    private static int boringbarbertime;
    private int leavewithoutservice;
    private Printer printer;
    private Queue que;
    private ArrayList<Thread> barbers = new ArrayList<>();
    private DebugClass debug = new DebugClass();

    public BarberShop(Printer printer, int cbarbers) {
        this.printer = printer;
        que = new Queue();
        try {
            for (int t = 0; t < cbarbers; t++) {
                barbers.add(new Thread(new Barber(6000)));
                barbers.get(t).setDaemon(true);
                barbers.get(t).start();
                System.out.println("создан барбер " + barbers.get(t));
                debug = new DebugClass();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized void setCustomer(List<Customer> cl) {
        System.out.println("Генератор передал клиентов в очередь: age " + cl.size());
        que.setCustomerList(cl);
    }
    // 
     public synchronized void setCustomer(List<Customer> cl, int hashcode) {
        System.out.println("Генератор передал клиентов в очередь: age " + cl.size());
        que.setCustomerList(cl, hashcode);
    }
    public static int getNonserviceclient() {
        // количество не обслуженых кле
        return nonserviceclient;
    }

    public class Queue {

        // Метод в 
        private Destructor dest;
        private List<Customer> customers = new ArrayList();

        public Queue() {
            // класс наследует старт 
            new Destructor().start();
        }

        public boolean isEmpty() {
            return customers.isEmpty();
        }

        public synchronized void setCustomerList(List<Customer> cls) {
            // если есть место то фиксируется все
            // Логика нет места уходят все 
            // Испольпользуем 
            int count;
            debug.printDebug(" код добавляемого массива " + cls.hashCode());
            try {
//                if (!customers.addAll(cl)) {
//                    nonqueclient = nonqueclient + cl.size();
//                    wait();
//                }
                if (cls.size() + customers.size() > 12) {
                    nonqueclient = nonqueclient + cls.size();
                    debug.printDebug(" код добавляемого массива " + cls.hashCode());
// нужно ли очищать. 
// Замораживаем 
                    wait();
                }
// время входа в кафе
                cls.forEach(x -> x.setEntrance());
//
                count = cls.size();
                System.out.println(" Добавлено в очередь новыx клиентов: + " + count + " в очередь  было " + customers.size());
                customers.addAll(cls);
                notifyAll();
            } catch (Exception e) {
                debug.printDebug("!!!!!!!!!!!!!!!!!!!!!!!!! Ошибка очереди !!!!!!!!!!!!!!!!!!!!!");
                e.printStackTrace();
            }
        }

        // Added paramentr
        public synchronized void setCustomerList(List<Customer> cls, int hashcode) {
            // если есть место то фиксируется все
            // Логика нет места уходят все 
            // Испольпользуем 
            int count;
            debug.printDebug(" код добавляемого массива " + cls.hashCode());
            try {
//                if (!customers.addAll(cl)) {
//                    nonqueclient = nonqueclient + cl.size();
//                    wait();
//                }
                if (cls.size() + customers.size() > 12) {
                    nonqueclient = nonqueclient + cls.size();
                    debug.printDebug(" код добавляемого массива " + cls.hashCode());
// нужно ли очищать. 
// Замораживаем 
                    debug.printDebug("Заморожен процесс customergenerator его hash " + hashcode);
                    wait();
                }
// время входа в кафе
                cls.forEach(x -> x.setEntrance());
//
                count = cls.size();
                System.out.println(" Добавлено в очередь новыx клиентов: + " + count + " в очередь  было " + customers.size());
                customers.addAll(cls);
                notifyAll();
            } catch (Exception e) {

            }
        }

        public synchronized Customer getClient(int hashcode) {
            Customer cl = null;
            try {
                if (customers.isEmpty()) {
                    debug.printDebug("Заморожен процесс customergenerator его hash " + hashcode);
                    wait();
                };
                cl = customers.remove(0);
                notifyAll();
                return cl;
            } catch (Exception e) {

            }
            return cl;
        }

        private class Destructor extends Thread {

            public Destructor() {
                this.setDaemon(true);
            }

            public void run() {
                System.out.println(" Запущен деструктор ");
                double sec;
                while (true) {
                    try {
                        if (customers.size() > 0) {
                            for (int r = customers.size() - 1; r >= 0; r--) {
                                long timewaite;
                                timewaite = System.currentTimeMillis() - customers.get(r).getEntance();
                                debug.printDebug(" клиент в деструкторе " + customers.get(r), 1);
                                if (timewaite > 2000) {
                                    // Описасть здесь     
                                    debug.printDebug(" время ожидания клиета более 2000 " + (timewaite / 1000.0));
                                    sec = (double) timewaite / 1000.0;
                                    debug.printDebug(" время в очереди " + sec);
                                    nonserviceclient++;
                                    System.out.println("Из очереди удален клиент  " + customers.get(r).getName() + " провел в очереди " + sec);
                                    customers.remove(r);
                                }
                            }
                        } else {
                            debug.printDebug("Деструктор засыпает очередь пуста", 1);
                            Thread.sleep(5000);
                        }
//                    customers.removeIf(x -> System.currentTimeMillis() - x.getEntance() > 2000);        
                    } catch (Exception e) {
                        debug.printDebug("!!!!!!!!!!!!!!!!!!!!!!!!! Ошибка деструктора !!!!!!!!!!!!!!!!!!!!!");
                        e.printStackTrace();
                     
                    }
                }
            }
        }
    }

    class Barber implements Runnable {

        private int currentcount;
        long timeworking;

        public Barber(long timeworking) {
            this.timeworking = timeworking;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    long cuttime;
                    if (!que.isEmpty()) {
                        Customer tem = que.getClient(this.hashCode());
                        currentcount++;
                        countallbarber++;
                        int m = tem.getModel();
                        cuttime = (m * 1000 + 1000);
                        timeworking = timeworking - cuttime;
                        System.out.println(" стригу клинента " + tem.toString() + " планируемое время стрижки " + (cuttime / 1000));
                        Thread.sleep(m * 1000 + 1000);
                    } else {
                        boringbarbertime += 50;
                        Thread.sleep(50);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * @return the currentcount
         */
        public int getCurrentcount() {
            return currentcount;
        }

    }
}
