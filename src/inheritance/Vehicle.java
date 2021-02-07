/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;
// Plane    Boat     Submarine      Bike
// Helicopter    Train   Bus    Samokat
// Car
// WaterPlane
/**
 *
 * @author Kamarali Anatolii
 */
public abstract class Vehicle {
    private boolean isTrigout;
    private int resurs;
    private double maxspeed;

     public Vehicle(int resurs, double speed){
       this.maxspeed = speed;
       this.resurs = resurs;
       this.setIsTrigout(true);
     }
    /**
     * @return the isTrigout
     */
    public boolean isIsTrigout() {
        return isTrigout;
    }
    
    public void setIsTrigout(boolean isTrigout) {
        this.isTrigout = isTrigout;
    }
    
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
              System.out.println(" остаток ресурса " + this.getResurs() + " пробег км " + (i * speed))   ;
              this.setResurs(this.getResurs() - 1);
          } else {
              this.setIsTrigout(false);
              System.out.println("Ресурс выработан требуется ремонт");
              return;
          }
          
      }
    
    }

    /**
     * @param run the run to set
     */
    public void setRun(int run) {
        this.setResurs(run);
        this.setIsTrigout(true);
        System.out.println(" Ресурс востановлен возможен пробег " +  run + " км ");
    }

    /**
     * @return the resurs
     */
    public int getResurs() {
        return resurs;
    }

    /**
     * @return the maxspeed
     */
    public double getMaxspeed() {
        return maxspeed;
    }

    /**
     * @param resurs the resurs to set
     */
    public void setResurs(int resurs) {
        this.resurs = resurs;
    }
    
}
