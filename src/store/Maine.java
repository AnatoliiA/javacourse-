/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;
import java.util.*;

/*import java.time.LocalDateTime; 
 *
 * @author Kamarali Anatolii
 */
public class Maine {
    public static void main(String[] args) {
        Store store = new Store("Walmart");
        Banan banan = new Banan(30);
        Barbie barbie = new Barbie(5.2, "45666899");
        Meat meat = new Meat(2, MEATS.BEEF);
        Ring ring = new Ring(5.0, true, 4.5, "2345666");
        ring.setVarJewerly(Material.GOLD);
        store.dispech(meat);
        store.dispech(banan);
        store.dispech(barbie);
        store.dispech(ring);
        System.out.println("" + store.toString());
        
    }
}
