/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Kamarali Anatolii
 */

//Plane    Boat     Submarine      Bike
//Helicopter    Train   Bus    Samokat
//Car WaterPlane
public class Maine {
    // resurs скорость speed ресурс 
    // самокат 5.0 скорость
    // средство передвижения мощность тип топлива
    public static void main(String[] args) {
       Samocat samocat = new Samocat(12, 5.0, 2);
//       samocat.running(15, 10);
//       samocat.setRun(22);
//       samocat.running(15, 3);
//        Car car = new Car(1000, 120.0, 120, FUEL.GASOLINE);
//        System.out.println(car.getBrand());
//        car.setBrand("Ford");
//        car.running(100, 80);
//        Bake bake = new Bake(500, 100);
//        bake.running(100, 82);
        Boat boat = new Boat();
        boat.dropAnchor();
        boat.running(2, 22);
        boat.setIsDroptAncor(false);
        boat.running(5000, 22);
        String value = boat.toString();
        
    }
    
}
