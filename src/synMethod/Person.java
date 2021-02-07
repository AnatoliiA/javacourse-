/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synMethod;


/**
 *
 * @author Kamarali Anatolii
 */
public class Person extends Thread {

    private String name;
    private Printer printer;

    public Person(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
            
            for (int i = 0; i < 5; i++) {
                
                printer.print("" + name);
                try {
                    this.sleep(500);
                } catch (Exception e) {
                }
                    
            }

    }

}
