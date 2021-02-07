/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

/**
 *
 * @author Kamarali Anatolii
 */
public class Cyrcle extends Figure {

    //private Type type = Type.CYRCLE;
    private int[][] coordinates;

    public Cyrcle(Color color, Thinkness thinkness) {
        super(color, thinkness);
        System.out.println(this.print());
    }

    @Override
    public String print() {
       // String f = super.print();
        return " хеш " + this.hashCode() +" фигура типа " + this.getClass().getName() + " c координатами ";
    }

    


}
