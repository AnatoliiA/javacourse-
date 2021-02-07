/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equals_hashcode;
import java.util.Date;
import java.util.*;
/**
 *
 * @author Kamarali Anatolii
 */
public class Maine {
    public static void main(String[] args) {
        String text = "Все біло в непорядке в доме Облонских";
        String text1 = new String("Все біло в непорядке в доме Облонских");
// передать массав сhar
//        System.out.println("" + (text == text1));
//        System.out.println("" + (text.equals(text1)));
        HashSet<Car> cars = new HashSet<>();
        ArrayList<Date> dates = new ArrayList<>();
        ArrayList<Car> carsaList = new ArrayList<>();
        Date date1 = new Date();
        Date date = new Date();
        dates.add(date);
       // dates.add(date1);
        
            Calendar calendar = new GregorianCalendar(2017, 0 , 25);
            Date date4 = calendar.getTime();
            System.out.println(date);
//        System.out.println("" + (date == date1));
//        System.out.println("" + (date.equals(date1)));
//      String brand, String model, long number, int doors, Date date
        
        Car car = new Car("Ford", "Focus", 1204550228, 4, date1);
        Car car1 = new Car("Ford", "Focus", 1204550228, 4 ,date1);
        Car cartav = new Car("Zaz", "Tavria", 188888889, 3 ,date4);
        Engine engine1 = new Engine("mustang", 120, 1.5);
        Engine engine = new Engine("mustang", 120, 1.5);
        
        
        
        
        car1.setEngine(engine1);
        car.setEngine(engine);
            System.out.println("машины одинаковы " + car.equals(car1));
//        System.out.println(car1);
        cars.add(car);
        cars.add(car1);
        System.out.println(" хеш саr "+ car.hashCode());
        System.out.println(" хеш саr1 "+ car1.hashCode());
        System.out.println(" хеш date1 "+ date1.hashCode());
        System.out.println(" хеш date "+ date.hashCode());
         System.out.println(" хеш date4 "+ date4.hashCode());
        System.out.println(" хеш string "+ "mustang".hashCode());
        System.out.println(" хеш string "+ "mustang".hashCode());
        
        cars.add(cartav);
        
        
        carsaList.add(car);
       // carsaList.add(car1);
        System.out.println(" array list containe " + carsaList.contains(car) + " " + car.toString());
//        System.out.println(" array list date containe " + dates.contains(date1));
        System.out.println(" array list containe " + carsaList.contains(car1) + " " + car1.toString());
        System.out.println(" array list remove " + carsaList.remove(car1) + " " + car1.toString());
        System.out.println(" array list index " + carsaList.indexOf(car1)+ " " + car1.toString());

        System.out.println(" hash set containe " + cars.contains(car1) +  " " + car1.toString());
        System.out.println(" hash set containe " + cars.contains(car) +  " " + car.toString());
        System.out.println(" hash set size " + cars.size());
        System.out.println(" hash set remove " + cars.remove(car1));
        
        
        
        
    }
}
