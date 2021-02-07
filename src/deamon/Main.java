/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deamon;

/**
 *
 * @author Kamarali Anatolii
 */
public class Main {

    public static void main(String[] args) {
        try {

            //Thread mainthread = Thread.currentThread();
            
            Ship ship = new Ship("Cухогруз");
            Truck truck = new Truck("Volvo");
            Printer printer = new Printer();
            System.out.println("" + truck.toString());
            // ауди
            Parking audipark = new Parking("Паркинг Ауди");
            CarFactory audi = new CarFactory(34, "Audi");
            audi.setParking(audipark);
            Thread audithd = new Thread(audi);
            //бмв
            Parking bmwpark = new Parking("Паркинг БМВ");
            CarFactory bmw = new CarFactory(34, "BMW");
            bmw.setParking(bmwpark);
            Thread bmwthd = new Thread(bmw);
            //Трак
            truck.setparking(audipark);
            truck.setparking(bmwpark);
            truck.setship(ship);
            Thread truckth = new Thread(truck);
            // буксир 
            Towboat towboat = new Towboat(ship);
            Thread towboadthd = new Thread(towboat);
            bmwthd.setDaemon(true);
            audithd.setDaemon(true);
            truckth.setDaemon(true);
            bmwthd.start();
            audithd.start();
            truckth.start();

            towboadthd.start();
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
