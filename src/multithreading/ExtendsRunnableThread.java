/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;
import java.util.*;
/**
 *
 * @author Kamarali Anatolii
 */
public class ExtendsRunnableThread extends Thread {
    private Random rnd = new Random();
    private Person person;

    public ExtendsRunnableThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("iteration " + i + " " + person.getName());
            try {
                sleep(300);
            } catch (Exception e) {
                
            }
        }

    }
}
