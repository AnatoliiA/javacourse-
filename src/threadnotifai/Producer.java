/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadnotifai;

import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
enum Manifactor {
    APPALE(18, 100.0), SAMSUNG(20, 80.0), XIOMI(21, 50.0);
    private int code;
    private double pricebase;

    Manifactor(int code, double pricebase) {
        this.code = code;
        this.pricebase = pricebase;
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return pricebase;
    }

    public HashMap getNamePrice() {
        HashMap<String, Double> name_price = new HashMap<>();
        name_price.put(this.name(), pricebase);
        return name_price;
    }

}

public class Producer implements Runnable {

    private Printer printer;
    private Random rn = new Random();
    private Shop shop;
    private static String laptop;
    private ArrayList<Product> stock = new ArrayList<>();
    private Manifactor brand;
    private int sn;

    public Producer(Shop shop, Manifactor brand, Printer printer) {
        this.shop = shop;
        this.brand = brand;
        this.printer = printer;
    }

    static {
        laptop = "Laptop";
//        tablet = "Tablet";
//        phone = "Phone";
    }

    @Override
    public void run() {

        while (true) {
            // не должен вінимать все методы 
            Product testProduct = new Product(brand, sn++);
            // синхронизированый блок
            synchronized (printer) {
                printer.print("Произведен товар и передан в магазин" + testProduct.toString() + "\n");
            }
            // отдать продукт магазину
            shop.addProduct(testProduct);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
        }

    }
}
