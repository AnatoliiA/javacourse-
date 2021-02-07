/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import com.sun.crypto.provider.HmacSHA1;
import java.util.Scanner;
import sun.security.krb5.internal.rcache.AuthList;

/**
 *
 * @author Kamarali Anatolii
 */
public class Point {

    protected int y;
    protected int x;
    private Scanner scanner = new Scanner(System.in);

    public Point() {
        do {
            System.out.println("Введите точкe x");
            x = scanner.nextInt();
            System.out.println("Введите точкe y");
            y = scanner.nextInt();
        } while (!((x <= 100 && x >= 0) || (y <= 100 && y >= 0)));
    }

    // не нравится
    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode * 37 + y;
        hashCode = hashCode * 37 + x;
        hashCode = hashCode << 1;
        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Point)) {
            return false;
        }
        Point point = (Point) object;
        return y == point.y && x == point.x;
    }


    public int[] getCoord() {
        if(x == 0) {
            System.out.println("переменная не определена");
            return null;
        }
        int[] b = new int[2];
        b[0] = x;
        b[1] = y;
        return b;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    // переопределить hash code 
    // переопределить equals 
    // одновременно переопределить так как вызывается вместе. 
}
