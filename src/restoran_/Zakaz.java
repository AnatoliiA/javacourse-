/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Kamarali Anatolii
 */
public class Zakaz {
    private Date date;
    private HashSet<Bludo> bludos = new HashSet<>();
    private double price;

    public Zakaz() {
        this.date = new Date();
    }

    public void printZakaz() {
        Calendar calendar = new GregorianCalendar();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getDate());
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minut = cal.get(Calendar.MINUTE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Дата заказа:  " + sdf.format(this.getDate()) + "\n"
                + "Время заказа: " + hours + "." + minut + " ");
        System.out.println("Заказано : " + bludos + " на сумму " + getPrice());
    }

    public Date getDate() {
        return date;
    }

    /**
     * @param bludos the bludos to set
     */
    public void setBludos(HashSet<Bludo> bludos) {
        this.bludos = bludos;
    }

  
    public void addBludo(Bludo bludo){
        this.price = bludo.getPrice() + this.getPrice();
        this.bludos.add(bludo);
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
     
}
