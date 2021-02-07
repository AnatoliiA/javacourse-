/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
public class Store {

    private JewerlyDepartment jewerlyDepartment = new JewerlyDepartment();
    private FoodDepartment foodDepartment = new FoodDepartment();
    private ToyDepartment toyDepartment = new ToyDepartment();
    private Dispecher dispecher = new Dispecher();
    private String name;

    public Store(String name) {
        this.name = name;
    }
    // если находится то оно и вызовет 

    @Override
    public String toString() {
        return "Супермаркет называется: " + this.name + "\n" + jewerlyDepartment + 
               "\n" + toyDepartment + "\n" + foodDepartment + "\n";
    }
    
    public void dispech(Product product){
            dispecher.dipech(product);
    };

    // провести ирархию до конца 
    class Dispecher {
        // для разделения на типы измользуют instanceOf 
        // Instance of (object , type) возращает тру или фолсе. 

        public void dipech(Product product) {

            if (product instanceof Jewerly) {
                // приведение типов 
                // фактички в ячейку 
                Jewerly juwerly = (Jewerly) product;
                jewerlyDepartment.setjewerlys(juwerly);
            } else if (product instanceof Food) {
                Food food = (Food) product;
                foodDepartment.setFoodsArrayList(food);
            } else if (product instanceof Toy) {
                Toy toy = (Toy) product;
                toyDepartment.setToysArrayList(toy);
            };
        }

    }

    class JewerlyDepartment {

        private String namedep = "Ювелирный департамент";
        private ArrayList<Jewerly> jewerlys = new ArrayList<>();

        public void setjewerlys(Jewerly jewerly) {
            jewerlys.add(jewerly);
        }

        @Override
        public String toString() {
            String back;
            back = "Общее количество товаров в " + this.namedep + " равно " + jewerlys.size() + "\n";
            for (Jewerly j : jewerlys) {
                back = back + j.toString();
            }
            return back;
        }

        /**
         * @return the namedep
         */
        public String getNamedep() {
            return namedep;
        }

    }

    class FoodDepartment {

        private ArrayList<Food> foodsArrayList = new ArrayList<>();
        private String namedep = "Продуктовый департамент";

        /**
         * @param foodsArrayList the foodsArrayList to set
         */
        public void setFoodsArrayList(Food food) {
            foodsArrayList.add(food);
        }

        @Override
        public String toString() {
            String back;
            if (foodsArrayList.size() == 0) {
                back = "Общее количество товаров в " + this.namedep + " равно " + foodsArrayList.size() + "\n";
            } else {
                back = "Отдел " + this.namedep + " пуст ";
            }
            for (Food f : foodsArrayList) {
                back = back + f.toString();
            }
            return back;
        }

        public String getNamedep() {
            return namedep;
        }
    }

    class ToyDepartment {

        private ArrayList<Toy> toysArrayList = new ArrayList<>();
        private String namedep = "Игровой департамент";

        /**
         * @param toysArrayList the toysArrayList to set
         */
        public void setToysArrayList(Toy toy) {
            toysArrayList.add(toy);
        }

        @Override
        public String toString() {
            String back;
            back = "Общее количество товаров в " + this.namedep + " равно " + toysArrayList.size() + "\n";
            for (Toy t : toysArrayList) {
                back = back + t.toString();
            }
            return back;
        }

        public String getNamedep() {
            return namedep;
        }

    }

}
