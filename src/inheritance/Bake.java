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
public class Bake extends Vehicleng_with_wheel{
    private String brand = "Noname";
    public Bake(int resurs, int enginepower) {
        super(resurs, 150.0, enginepower, FUEL.GASOLINE, 2);
//        if(enginepower > 90){
//            System.out.println("Нет возможности создать такой байк, уменьшите мощность");
//            return;
//        };
        
    }
    
}
