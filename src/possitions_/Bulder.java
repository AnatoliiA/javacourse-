/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possitions_;

/**
 *
 * @author Kamarali Anatolii
 */
public class Bulder extends Human{
    private String cvalifaer;
    
    public Bulder (int age, int gender, String name, String education, int income, String cvalifaer){
     super(age, gender, name, education, income);
     this.cvalifaer = cvalifaer;
    }
    // конретный класс обязан !!! абстрактный метод переписать
    @Override
    public void working(){
        System.out.println("working v");
    }
    
    public String info(){
       return  super.info() + " " + this.cvalifaer;
    }
}
