/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

/**
 *
 * @author Kamarali Anatolii
 *
 */
public abstract class Figure {

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the thickness
     */
    public Thinkness getThickness() {
        return thickness;
    }
    // напрямую не приват а протектед 
    // и я к ним доступаюсь 

    protected Point point1;
    protected Point point2;
    private Color color;
    private Thinkness thickness;

    public Figure(Color color, Thinkness thinkness) {
        do {
            this.point1 = new Point();
            this.point2 = new Point();
        } while (point1.equals(point2));
        this.thickness = thinkness;
        this.color = color;
    }

    public void changePoint1(int x, int y) {
        int xx = x + this.point1.x;
        int yy = y + this.point1.y;
        if (((x <= 100 && x >= 0) || (y <= 100 && y >= 0))) {
            this.point1.setX(xx);
            this.point1.setY(yy);
        } else {
            System.out.println("Координаты выходят за уровень доски");
        }
        print();
    }

    public void changePoint2(int x, int y) {
        int xx = x + this.point2.x;
        int yy = y + this.point2.y;
        if (((x <= 100 && x >= 0) || (y <= 100 && y >= 0))) {
            this.point2.setX(xx);
            this.point2.setY(yy);
        } else {
            System.out.println("Координаты выходят за уровень доски");
        }
        print();
    }

    public int[][] getcoord() {
        int[][] int_c = new int[2][2];
        int_c[0] = point1.getCoord();
        int_c[1] = point2.getCoord();
        return int_c;
    }
    // в цикле методо вызваем move'

    public void move(int x, int y) {
        // this.point = new point()
        this.changePoint1(x, y);
        this.changePoint2(x, y);
        print();
    }

    public abstract String print();
//            int [] mas = new int[4];
//            mas[0] = point1.getX();
//            mas[1] = point1.getY();
//            mas[2] = point2.getX();
//            mas[3] = point2.getY();
//            return "X: " + mas[0] + "|" + mas[1] + " Y: " + mas[2] + "|" + mas[3];
//     }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object.getClass() == this.getClass()) {
            Figure figure = (Figure) object;
            return this.point1.x == figure.point1.x && this.point1.y == figure.point2.y
                      && this.point2.y == figure.point2.y && this.point1.x == this.point1.x;
            // + сравнение по коорединатам
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 34;
        hashCode = hashCode * 34 + point1.x;
        hashCode = hashCode * 34 + point1.y;
        hashCode = hashCode * 34 + point2.x;
        hashCode = hashCode * 34 + point2.y;
        return hashCode;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
        print();
    }

    /**
     * @param thickness the thickness to set
     */
    public void setThickness(Thinkness thickness) {
        this.thickness = thickness;
        print();
    }
}
