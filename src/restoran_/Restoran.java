/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.*;
import java.time.Period;

/**
 *
 * @author Kamarali Anatolii
 */
public class Restoran {

    private int count = 0;
    private HashSet<Bludo> menu = new HashSet<>();
    private HashMap<Integer, Zakaz> zakaziHashMap = new HashMap<Integer, Zakaz>();
    private Scanner scanner = new Scanner(System.in);

    public Restoran() {
        String[] namebl = {"Окрошка", "Борщ", "Греческий салат", "Картошка", "Пиво"};
        Double[] namecl = {30.50, 25.50, 18.50, 30.0, 50.0};
        Double[] prices = {30.50, 25.50, 18.50, 30.0, 50.0};
        for (int i = 0; i < 4; i++) {

//             System.out.println("" + namebl[i] + " " + menu.size());
            Bludo bludo = new Bludo(namebl[i], namecl[i], i);
            bludo.setPrice(prices[i]);
//             System.out.println("" + bludo.toString());
            menu.add(bludo);
        }
        this.menu();
    }
    private void menu(){
        // БЕСКОНЕЧНЫЙ ЦИКЛ ИЛИ РЕКУРСИЕЙ
       this.makeZakaz();
    
    }
    private void makeZakaz() {
        int i = 0;
        boolean bol = false;
        Zakaz zakazmZakaz = new Zakaz();
        ArrayList<Bludo> arr = new ArrayList<>();
        arr.addAll(menu);
        int co = -1;
        do {
            do {
                System.out.println("выберете блюдо или выйдете введите -1");
                for (int z = 0; z < arr.size(); z++) {
                    System.out.println(" выбор № " + z + " блюдо " + arr.get(z).toString());
                }
                co = scanner.nextInt();
               // System.out.println(" d " + co + " " + (co <= 3 || co >= 0));
                if (co <= 3 && co >= 0) {
                    zakazmZakaz.addBludo(arr.get(co));
                    bol = true;
                } else {
                    System.out.println("Значение не верно заказ не сделан");
                }
//                System.out.println("!(co < 0 && co > 3 && co != -1) " + !(co < 0 && co > 3 && co != -1));
//                System.out.println("!(co < 0 || co > 3 || co != -1) " + !(co < 0 || co > 3 || co != -1));
//                System.out.println("!(co < 0 || co > 3 && co != -1) " + !(co < 0 || co > 3 && co != -1));
            } while (!(co < 0 || co > 3 || co != -1));
        } while (co != -1);
        if (bol) {
            System.out.println("Заказ сделан .... ваш заказ ... ");
            zakazmZakaz.printZakaz();
            count++;
            zakaziHashMap.put(count, zakazmZakaz);
            System.out.println(" мапа " + zakaziHashMap.size());
        }
    }

    private void makeZvit() {
        if(zakaziHashMap.size()==0){
            System.out.println("Ресторан не открыт баланс 0");
            return;
        }
        Scanner scanner1 = new Scanner(System.in);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        String startDate_;
        String endDate_;
        double doub = 0;
        boolean bol = true;
        System.out.println("Введите дату начала отчета в формате YYYY-MM-DD");
        startDate_ = scanner1.nextLine();
        //   System.out.println("" + startDate_);
        LocalDate startDate = LocalDate.parse(startDate_);
        // End date 
        System.out.println("Введите дату конца отчета в формате YYYY-MM-DD");
        endDate_ = scanner1.nextLine();
        LocalDate endDate = LocalDate.parse(endDate_);
        if (endDate.isBefore(startDate)) {
            System.out.println("Даты подобраны не правильно операция прекращается");
            return;
        }
        for (int i = 1; i < zakaziHashMap.size() + 1; i++) {
            // zakaziHashMap.get(i).printZakaz();
            Zakaz zakaz = zakaziHashMap.get(i);
            LocalDate date = convertToLocalDateViaInstant(zakaz.getDate());
            System.out.println("" + endDate.isAfter(date));
            if (endDate.isAfter(date) && startDate.isBefore(date)) {
                System.out.println(" Заказ №" + i);
                zakaz.printZakaz();
                bol = false;
                doub = doub + zakaz.getPrice();
            }
        }
        if (!bol) {
            System.out.println("Общая ссума заказов за период " + doub);
        }
        if (bol) {
            System.out.println("Заказов за период не было");
        }
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
};
