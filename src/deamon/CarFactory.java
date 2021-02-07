package deamon;


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

    public int volume;
    public String name;
    public int serial;
    public Parking parking;

    public CarFactory(int volume, String breand) {
        this.volume = volume;
        this.name = breand;
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
                
                ENGINE engine = ENGINE.values()[new Random().nextInt(2)];
                Car car = new Car(serial++, this.name, engine);
                System.out.println(" Заводом " + this.name + " произведена новая машина " + car);
                parking.setCar(car);
                volume--;
                System.out.println(" В паркинге " + name + " осталось свободных мест " + parking.getCountEmpty());
           
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
        
    }

}
