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
public abstract class Vehicle_swming extends Vehiclewithengine{
    private Ancor ancor;
    private boolean isDroptAncor;
    
    
    public Vehicle_swming(int resurs, double speed, int enginepower, FUEL fuel, int ancor) {
        super(resurs, speed, enginepower, fuel);
        this.ancor = new Ancor(ancor);
    }
    
    public void dropAnchor(){
            System.out.println("Якорь выброшен");
            this.setIsDroptAncor(true);
    }
    
    @Override
    public void running (int run, double speed){
      if(!this.isIsTrigout()) {
             System.out.println("Нет   возможности передвигаться, требуется ремонт");
             return;
      }else if(this.isIsDroptAncor()){
             System.out.println("Якорь сброшен необходимо его поднять");
             return;
      };
      if(speed > this.getMaxspeed()) {
          System.out.println(" Превішена максимальная скорость установлен органичитель скорости  ");
          speed = this.getMaxspeed();
      }    
      for(int i =1; i<run; i++){
          if(this.getResurs() != 0){
              System.out.println( " " + this.getResurs() + " пробег км " + (i * speed))   ;
              this.setResurs(this.getResurs() - 1);
          } else {
              this.setIsTrigout(false);
              System.out.println("Ресурс выработан требуется ремонт");
              return;
          }
}
      }
      
          /**
     * @return the isDroptAncor
     */
    public boolean isIsDroptAncor() {
        return isDroptAncor;
    }

    /**
     * @param isDroptAncor the isDroptAncor to set
     */
    public void setIsDroptAncor(boolean isDroptAncor) {
        this.isDroptAncor = isDroptAncor;
    }
      
}


