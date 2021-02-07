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
public abstract class Human {
    
    // protected поля могут видимы наследниками напрямую
    
    protected int age;
    protected int gender;
    public String name;
    protected String education;
    protected int income;
    
    public Human(int age, int gender, String name, String education, int income){
            this.age = age;
            this.gender = gender;
            this.name = name;
            this.education = education;
            this.income = income;
    }
    // конретный класс обязан !!! абстрактный метод переписать
    public abstract void working();
    
    public String getName(){
      return name;
    }
    
    public String info(){
       return " Человек возраст " + this.age + " Пол " + this.gender + " ";
    }
    // переопределение метода overithg предопределеного системой
    //  Написать object и клацнуть два раза
    public String toString(){
       return " Возраст " + this.age + " Пол " + this.gender + " ";
    }
    
    public void eating(){
        System.out.println("Eating ....");
    }
}
// написать классы и увидеть наследование наследование, что наследует, методы поля общие не общие return " Человек возраст " + this.age + " Пол " + this.gender + " ";

