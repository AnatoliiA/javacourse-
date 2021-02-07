/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadnotifai;

import java.util.*;
import java.io.IOException;

/**
 *
 * @author Kamarali Anatolii
 */
public class Shop {

    private Printer printer;
    private Product[] stock = new Product[15];
    boolean valSet = false;

    public Shop(Printer printer) {
        this.printer = printer;
    }

    // синхронизированный метод public synchronized boolean
    public synchronized boolean isFull() {
        for (int y = 0; y < stock.length; y++) {
            if (stock[y] == null) {
                return false;
            }
        }
        return true;
    }

    // синхронизированный метод public synchronized void
    public synchronized void addProduct(Product product) {
        try {
            if (isFull()) {
                this.wait();
            }
                Boolean bool = false;
                System.out.println("Получен товар " + product);
                for (int e = 0; e < stock.length; e++) {
                    if (stock[e] == null) {
                        bool = true;
                        // принтер печатает 
                        synchronized (printer) {
                            // печать сделать в текстовый файл
                            // никто не может использовать
                            printer.print("Товар поступил на склад " + product.toString());
                        }

                        stock[e] = product;
                        notifyAll();
                        return;
                    }
                }

                if (!bool) {
                    System.out.println("Товар не может быть принят все ячейки заняты");
                }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        // shop печатать в тот же файл что  и продуюсер 
    }

    public synchronized Product getProduct(Manifactor m) {
        if (stock.length == 0) {
            System.out.println(" продуктов нет ");
            return null;
        }
        for (int i = 0; i < getStock().length; i++) {
            Product product = stock[i];
            if (product != null) {
                if (m.equals(product.getBrand())) {
                    stock[i] = null;
                    synchronized (printer) {
                        // печать сделать в текстовый файл
                        // никто не может использовать
                        String text = "Куплен продукт: " + product.toString();
                        printer.print(text);
                    }
                    return product;
                }
            }
        }
        System.out.println(" продукта нет в магазине ");
        return null;
    }

    /**
     * @return the stock
     */
    public Product[] getStock() {
        return stock;
    }

}
