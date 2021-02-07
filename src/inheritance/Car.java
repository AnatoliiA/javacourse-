/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Kamarali Anatolii
 */
public class Car extends Vehicleng_with_wheel{ 
    private String brand = "Noname";
    private boolean isMagnitola;

    public Car(int resurs, double speed, int enginepower, FUEL fuel) {
        super(resurs, speed, enginepower, fuel, 4);
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the isMagnitola
     */
    public boolean isIsMagnitola() {
        return isMagnitola;
    }
    @Override
    public void running (int run, double speed){
      if(!this.isIsTrigout()) {
             System.out.println("Нет   возможности передвигаться, требуется ремонт");
             return;
      }
      if(speed > this.getMaxspeed()) {
          System.out.println(" Превішена максимальная скорость установлен органичитель скорости  ");
          speed = this.getMaxspeed();
      }    
      for(int i =1; i<run; i++){
          if(this.getResurs() != 0){
              System.out.println(" остаток ресурса машины " + this.getBrand()+ " " + this.getResurs() + " пробег км " + (i * speed))   ;
              this.setResurs(this.getResurs() - 1);
          } else {
              this.setIsTrigout(false);
              System.out.println("Ресурс выработан требуется ремонт");
              return;
          }
          
      }
    /**
     * @param isMagnitola the isMagnitola to set
     */
    }
    
}
