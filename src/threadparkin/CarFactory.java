package threadparkin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamarali Anatolii
 */
public class CarFactory implements Runnable {
    private Printer printer;
    private int volume;
    private String name;
    private int serial;
    public Parking parking;

    public CarFactory(int volume, String breand, Printer printer) {
        this.volume = volume;
        this.name = breand;
        this.printer = printer;
    }
    // public  Car produceFactory();

    public void setParking(Parking parking) {
//        if (!parking.isUsed()) {
//            System.out.println("Паркинг уже занят не может быть использован");
//            return;
//        }
//        parking.toggleIsUSedByMan();
        this.parking = parking;
    }

    
    
    @Override
    public void run() {
        while (volume > 0) {
           if((parking.getfront() == 0 && parking.getBack() ==0) || parking.getBack() != 6){
                ENGINE engine = ENGINE.values()[new Random().nextInt(2)];
                Car car = new Car(serial++, this.name, engine);
                String str = " Заводом " + this.name + " произведена новая машина " + car;
                System.out.println(str);
                synchronized (printer) {
                    printer.print(str);
                }
                parking.setCar(car);
                volume--;
                
           };
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
        }
    }

}
