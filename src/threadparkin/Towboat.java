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
public class Towboat implements Runnable {

    private Printer printer;
    private Ship ship;

    public Towboat(Ship ship, Printer printer) {
        this.ship = ship;
        this.printer = printer;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            System.out.println("Буксир провереяет заполене ли корабль " + ship.getName());
            if (ship.isFull()) {
                ship.removeCars();
                count--;
                System.out.println("Принял все мащины начал буксировку!!!");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // обязатtльно  InterruptedException e
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return " Буксир корабля " + ship;
    }
}
