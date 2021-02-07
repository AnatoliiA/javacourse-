/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possitions_;
import java.util.*;
/**
 *
 * @author Kamarali Anatolii
 */
public class Maine {
    public static void main(String[] args) {
        ArrayList<Human> humanList = new ArrayList<>();
        Doctor doc = new Doctor(18, 12, "Vasa", "High", ProfecionDoctor.SURWAY, 35, 11);
        Doctor doc1 = new Doctor(18, 12, "Vasa", "High", ProfecionDoctor.SURWAY, 35, 11);
//        Human hum = new Human(35, 10, "Prte", "Middle", 4);
        System.out.println("" + doc.info());
        Bulder bulder = new Bulder(35, 18, "John" , "Middle", 20000, "Bilder");
        Human bulder1 = new Bulder(35, 18, "John" , "Middle", 20000, "Bilder");
        // Ярлык может быть связан с любым предком в данном случае 
        Collections.addAll(humanList, doc, bulder, doc1, bulder1);
//        for(Human h: humanList){
//           System.out.println(h.info());
//        }
//        Date date = new Date();
//        System.out.println("" + date);
//        String str = new String("text");
//        System.out.println("" + str);
//        System.out.println("" + bulder);
         doc.eating();
         doc.eating("colbasa");
         System.out.println("" + doc.toString());
    }
}
