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
public class Rectangle extends Figure {

    private Type type = Type.RETANGLE;

    public Rectangle(Color color, Thinkness thinkness) {
        super(color, thinkness);
        System.out.println(this.print());
    }

    @Override
    public String print() {
       // String f = super.print();
        return " хеш " + this.hashCode() +" фигура типа " + type.toString() + " c координатами ";
    }

    
    

}
