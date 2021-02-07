/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadparkin;

/**
 *
 * @author Kamarali Anatolii
 */
public class Main {
    public static void main(String[] args) {
        
        Printer printer = new Printer();
        Ship ship = new Ship("Cухогруз", printer);
        PackHouse packHouse = new PackHouse("Склад", printer);
        Truck truck  = new Truck("Volvo", packHouse, printer);
        // ауди
        Parking audipark = new Parking("Паркинг Ауди", printer);
        CarFactory audi = new CarFactory(34, "Audi", printer);
        audi.setParking(audipark);
        Thread auditr = new Thread(audi);
        //бмв
        Parking common = new Parking("Паркинг Общий", printer);         
        CarFactory bmw = new CarFactory(34, "BMW", printer);
        bmw.setParking(common);
        Thread bmwtr = new Thread(bmw);
        //skoda
        CarFactory skodacf = new CarFactory(69, "Skoda", printer);
        skodacf.setParking(common);
        Thread skodatr = new Thread(skodacf);
        //Трак
        truck.setparking(audipark);
        truck.setparking(common);
        truck.setship(ship);
        Thread truckth = new Thread(truck);
        // буксир 
        Towboat towboat = new Towboat(ship, printer);
        Thread towboadthd = new Thread(towboat);
        bmwtr.start();
        auditr.start();
        truckth.start();
        skodatr.start();
        
        towboadthd.start();
        try {
            bmwtr.join();
            towboadthd.join();
            auditr.join();
            skodatr.join();
            truckth.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        printer.closebuffed();
    }
}
