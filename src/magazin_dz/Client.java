/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazin_dz;

import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class Client implements Runnable {

    private Shop shop;
    private Printer printer;
    private ArrayList<Product> products = new ArrayList<>();
    private String name;
    private int age;

    public Client(Shop shop, Printer printer, String name, int age) {
        this.age = age;
        this.printer = printer;
        this.shop = shop;
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the printer
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * @return the shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int z = new Random().nextInt(5) + 10;

        while (z > 0) {
            if (!shop.isEmpty()) {
                Product product = null;
                // Scanner myScanner = new Scanner(System.in);
                // System.out.println("Введите продукт какого производителя вы хотите приобрести \n"
                //           + "1 Xiomi 2 Sumsung 3 Apple  0 Выйти ");
                // String key = myScanner.nextLine();
                int key = new Random().nextInt(3) + 1;
                Manifactor mantemp = Manifactor.values()[new Random().nextInt(3)];
                product = shop.getProduct(mantemp);
                String stemp = (product != null) ? "Клиент " + this.name + " получил" + product.toString() + "\n"
                          : "Клиент " + this.name + "не получил товар " + mantemp.name() + "\n";
                System.out.println(stemp);
                products.add(product);
                synchronized (printer) {
                    printer.print(stemp);
                }
                if((product != null)) z--;

            } else {
                System.out.println("В магазине нет товаров");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
        }
    }
}
