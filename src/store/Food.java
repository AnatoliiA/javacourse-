/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
/**
 *
 * @author Kamarali Anatolii
 */
public abstract class Food extends Product{
    private LocalDateTime expDate = LocalDateTime.now();
    private DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
    public Food(double price, int day){
        super(price);
        this.expDate = expDate.plus(Period.ofDays(day));
    };

    /**
     * @return the expDate
     */
    @Override
    public String toString() {
        return "Цена продукта $" + this.getPrice() + " Дата хранения истекает " + expDate.format(myFormatObj).toString() + " \n";
    }
     
    
}
