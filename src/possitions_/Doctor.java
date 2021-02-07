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
enum ProfecionDoctor{
    SURWAY, TERAPEVT;

}
public class Doctor extends Human{
    private ProfecionDoctor docprof;
    private int expirence;
    
    public Doctor(int age, int gender, String name, String education, ProfecionDoctor prof, int exp, int income){
        // сначала наследуем потом заполняем свои позиции
        // не смотря на невозможность создания абстрактного класса 
        // мы можем пользоваться его конструктором в наследниках
        // контруктор не наследуется а просто вызывается в наследниках
        super(age, gender, name, education, income);
        this.docprof = prof;
        this.expirence = exp;
    }
    // конретный класс обязан !!! абстрактный метод переписать
    // каждый метод должен быть переопределен иначе ошибка

    /**
     vbbbb       
     */
    @Override
    public void working(){
       this.treathuman();
    }
    // поля помеченые протектед могут напрмую видимы наследниками без методовв
    @Override
    public String info(){
        return super.info() + "Доктор специализация " + this.docprof;
    }
    
    // перегрузка метод 
    // не существует указателя
    public void eating(String food){
        System.out.println("eating " + food);
    }
    @Override
     public String toString(){
       return super.toString() + " Доктор специализация " + this.docprof;
    }
    
    
    public void treathuman(){
        System.out.println("cure cure");
    }
}
