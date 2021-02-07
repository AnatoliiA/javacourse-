/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazin_dz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kamarali Anatolii
 */
// тема ввода и вывода
public class Printer {
    private int i;
    String inputFileName = "shopstick.txt";
    BufferedWriter bufwriter;

    public Printer() {
        try {
            bufwriter = new BufferedWriter(new FileWriter(new File(inputFileName), true));
        } catch (IOException e) {
            e.printStackTrace();        }
    }

    public void print(String text) {
        
        try {
            System.out.println("\n" + text + " поступил на принтер.." + i++);           
            bufwriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    public boolean closebuffed() {
        if (bufwriter != null) {
            try {
                bufwriter.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
