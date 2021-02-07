/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Kamarali Anatolii
 */
public class ImplimentRunnablePrint implements Runnable{
     @Override
    public void run() {
         for (int i = 0; i < 100; i++) {
              System.out.println("" + new SimpleDateFormat("hh:mm:ss").format(new Date()));  
              try {
                  Thread.sleep(300);
             } catch (Exception e) {
             }
         }
          
    }
   
}
