/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.util.*;

/**
 *
 * @author Kamarali Anatolii
 */
enum Color {
    RED, BLUE, GREY, BlACK
}

enum Thinkness {
    ONE(1), TWO(1), THREEP(3);
    private int wth;

    private Thinkness(int i) {
        this.wth = i;
    }

    /**
     * @return the wth
     */
    public int getWth() {
        return wth;
    }
}

enum Type {
    RETANGLE, CYRCLE, ELLIPCE
}

public class Paint {

    private Scanner scanner = new Scanner(System.in);
    // необходимо изменить сам цвет по умолчнию для изменения фигуры.
    // но если при этом список существует
    // все фигуры которые находятся в selectedFigure поменяют цвет в мемент измения 
    // Сссылки на фигуры содержатся в аrray list при изменении одного изменится другой лист. 
    // Функция перемещения все фигурі должні переместится на ту или другую велеичину которую я задаю 
    // Для єтого создаются новіе поинті для для новых координат фигуры. 
    private Color color = Color.BlACK;
    private Thinkness thinkness = Thinkness.ONE;
    //созданая фигура добовлятся
    private ArrayList<Figure> hasHSettpaint = new ArrayList<>();
    private HashSet<Figure> selectedFigureinPaint = new HashSet<>();

    //Шаблон проектирования 
    // Фабричный методы 
    // Sigle tone 
    // метод назвается фабричнім поскольку вырабатывает фигуру
    // и должен быть который принимает фигуру 
    // фабричный метод
    public Figure createfabricFigure(Type type) {
//       Swich(type){
//        case RETANGLE
//        Figure fugureA = new type;
//      }
        switch (type) {
            case RETANGLE:
                Rectangle rectangle = new Rectangle(this.color, this.thinkness);
                return rectangle;
            case CYRCLE:
                Cyrcle cyrcle = new Cyrcle(this.color, this.thinkness);
                return cyrcle;
            default:
                return null;
        }
    }

    public void createFigures() {
        int y = 0;
        do {
            ArrayList<Type> types = new ArrayList<>();
            types.toArray(Type.values());
            System.out.println(" для выхода нажмите - 1");
            for (int i = 0; i < types.size(); i++) {
                System.out.println("выбор создания фигуры" + i
                          + " имя " + types.get(i).name());
            }
            y = scanner.nextInt();
            Figure fig = this.createfabricFigure(types.get(y));
            System.out.println("Cоздана фигура:");
            fig.print();
            hasHSettpaint.add(fig);
        } while (y != -1);
    }

    public void eraseAllHashset() {
        hasHSettpaint.clear();
        selectedFigureinPaint.clear();
    }
    
    public void errseSelectedFig(){
      hasHSettpaint.clear();
    }
    

    public void select() {
        ArrayList<Figure> array_list = new ArrayList<>();
        array_list.addAll(hasHSettpaint);
        int i = 0;

        do {
            System.out.println("Выберите фигуры которые надо выбрать для выхода нажмите -1");
            for (int z = 0; z < array_list.size(); z++) {
                System.out.println("номер " + i + " " + array_list.get(i).print());
            }
            i = scanner.nextInt();
            Figure fig = array_list.get(i);
            fig.setColor(this.color);
            fig.setThickness(this.thinkness);
            selectedFigureinPaint.add(fig);
            System.out.println("Добавлено фигура" + fig.print());
        } while (i == -1);

    }

    public Paint() {
        HashSet<Figure> hasTemp = new HashSet<>();
        hasTemp.addAll(hasHSettpaint);
        System.out.println("Выделены следующие фигуры");
        for (Figure f : selectedFigureinPaint) {
            f.print();
            hasTemp.remove(f);
        }
        System.out.println("Оставшиеся фигуры следующие фигуры");
        for(Figure m: hasTemp){
            m.print();
        }
    }

    public void MoveselectCoord() {
        int[][] coord = new int[2][2];
        int sdvig;
        System.out.println("Введите координаты ввести:");
        for(int u = 0; u<2;u++){
            for(int y =0; y<2; y++){
              System.out.println("Введите координаты + " + (u+1) + " координата" + (y+1));
              coord[u][y] = scanner.nextInt();
            }
        }
        if(coord[0][0] == coord[1][0] && coord[0][1] == coord[1][1]){
            System.out.println("Это точка: введите еще раз");
            MoveselectCoord();
        }; 
        System.out.println("На сколько сдвинуть фигуру: ");
        sdvig = scanner.nextInt();
        
    }
    public void copyFigure(){
    select();
       for(Figure fig:selectedFigureinPaint){
           if(fig instanceof Rectangle){
            Rectangle regtRectangle = new Rectangle(color, thinkness);
            regtRectangle.setColor(fig.getColor());
            regtRectangle.setThickness(fig.getThickness());
           }
           
       }
    
    };
};



//    public void moveFig() {
//        if (selectedFigure.isEmpty()) {
//            System.out.println("Нет выделных фигур .... ");
//            return;
//        };
//        System.out.println("Coord till changes");
//        for (Figure figure : selectedFigure) {
//            System.out.println(figure.print());
//        }
//        System.out.println("Введите на сколько подвинуть фигуры ось Х");
//        int x = scanner.nextInt();
//        System.out.println("Введите на сколько подвинуть фигуры ось Y");
//        int y = scanner.nextInt();
//        if (selectedFigure.size() == 0) {
//            System.out.println("Нет віделеных фигур");
//            return;
//        }
//        for (Figure figure : selectedFigure) {
//            figure.changePoint1(x, y);
//            figure.changePoint2(x, y);
//            System.out.println(figure.print());
//        }
//    }
// заменить одну
// нужно візалть логику из метода селект 
// и потом удалить 
// нужно искать оптимальніе пути а не писать таким образом. 
// использовать для удаления метод ремe all 
// rjhzdj 
// нужно по коорединатм 
// нужно біло использовать сет тогда не біло дубликатова 
// можно переопредлить equals
// можно использовать map если его использовать ключом

