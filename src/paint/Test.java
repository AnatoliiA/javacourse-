///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package paint;
//
//import java.awt.*;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.awt.Toolkit;
//
///**
// *
// * @author Kamarali Anatolii
// */
//public class Test {
//
//    public abstract class Geom_f {
//
//        int Rad_X;
//        int Rad_Y;
//        int angle;
//        int speed;        // the speed of the rotation
//        Color clr;
//
//        public Geom_f(int Rad_X, int Rad_Y,
//                int angle, int speed,
//                Color clr) {
//            this.Rad_X = Rad_X;
//            this.Rad_Y = Rad_Y;
//            this.angle = angle;
//            this.speed = speed;
//            this.clr = clr;
//        }
//
//        void step(int X_0, int Y_0,
//                int Col, int Pos,
//                int pixX[], int pixY[]) {
//            Pos += speed;
//            double angR = ((Pos * StrictMath.PI) / 180); // Угловое положение в радианах
//            if (Pos % 360 == 0) {
//                Pos = 0;
//                angR = 0;
//            }
//            double Angle = 0;    // Угловое положение точки ломаной линии
//            int buf;
//            for (int i = 0; i < Col; i++) {
//                buf = (int) StrictMath.cos(angR + Angle);
//                pixX[i] = (int) X_0 + Rad_X * buf;
//                buf = (int) StrictMath.sin(angR + Angle);
//                pixY[i] = (int) Y_0 + Rad_Y * buf;
//
//                Angle += (2 * StrictMath.PI) / Col;
//            }
//            pixX[Col] = pixX[0];
//            pixY[Col] = pixY[0];
//        }
//
//        abstract void draw(Graphics g);
//
//        abstract void stir(Graphics g);
//    }
//
//    class Line extends Geom_f {
//
//        Graphics g;
//        int pixX[] = new int[2];
//        int pixY[] = new int[2];
//        int Pos;
//
//        public Line(int Rad_X, int Rad_Y,
//                int angle,
//                int speed,
//                Color clr) {
//            super(Rad_X, Rad_Y, angle, speed, clr);
//            Pos = angle;
//            pixX[0] = 200 - Rad_X;
//            pixY[0] = 200 - Rad_Y;
//            pixX[1] = 200 + Rad_X;
//            pixY[1] = 200 + Rad_Y;
//        }
//
//        public void draw(Graphics g) {
//            g.setColor(clr);
//            g.drawLine(pixX[0], pixY[0], pixX[1], pixY[1]);
//        }
//
//        public void stir(Graphics g) {
//            g.setColor(Color.blue);
//            g.drawLine(pixX[0], pixY[0], pixX[1], pixY[1]);
//        }
//    }
//// Класс квадрат
////
////
//
//    class Square extends Geom_f {
//
//        int pixX[] = new int[4];
//        int pixY[] = new int[4];
//        int Pos;
//
//        public Square(int Rad_X, int Rad_Y,
//                int angle,
//                int speed,
//                Color clr) {
//            super(Rad_X, Rad_Y, angle, speed, clr);
//            Pos = angle;
//            pixX[0] = 400 - Rad_X;
//            pixY[0] = 600 - Rad_Y;
//            pixX[1] = 400 + Rad_X;
//            pixY[1] = 600 - Rad_Y;
//            pixX[2] = 400 + Rad_X;
//            pixY[2] = 600 + Rad_Y;
//            pixX[3] = 400 - Rad_X;
//            pixY[3] = 600 + Rad_Y;
//        }
//
//        public void draw(Graphics g) {
//            g.setColor(clr);
//            g.drawLine(pixX[0], pixY[0], pixX[1], pixY[1]);
//            g.drawLine(pixX[1], pixY[1], pixX[2], pixY[2]);
//            g.drawLine(pixX[2], pixY[2], pixX[3], pixY[3]);
//            g.drawLine(pixX[3], pixY[3], pixX[0], pixY[0]);
//        }
//
//        public void stir(Graphics g) {
//            g.setColor(Color.blue);
//            g.drawLine(pixX[0], pixY[0], pixX[1], pixY[1]);
//            g.drawLine(pixX[1], pixY[1], pixX[2], pixY[2]);
//            g.drawLine(pixX[2], pixY[2], pixX[3], pixY[3]);
//            g.drawLine(pixX[3], pixY[3], pixX[0], pixY[0]);
//        }
//    };
//// Класс треугольник
////
////
//
//    class ThrAng extends Geom_f {
//
//        int pixX[] = new int[3];
//        int pixY[] = new int[3];
//        int Col;
//        int Pos;
//
//        public ThrAng(int Rad_X, int Rad_Y,
//                int angle,
//                int speed,
//                Color clr) {
//            super(Rad_X, Rad_Y, angle, speed, clr);
//
//            Pos = angle;
//            pixX[0] = 600 - Rad_X;
//            pixY[0] = 200 - Rad_Y;
//            pixX[1] = 600 + Rad_X;
//            pixY[1] = 200 - Rad_Y;
//            pixX[2] = 600;
//            pixY[2] = 200 + Rad_Y;
//        }
//
//        public void draw(Graphics g) {
//
//            g.setColor(clr);
//            g.drawLine(pixX[0], pixY[0], pixX[1], pixY[1]);
//            g.drawLine(pixX[1], pixY[1], pixX[2], pixY[2]);
//            g.drawLine(pixX[2], pixY[2], pixX[0], pixY[0]);
//        }
//
//        public void stir(Graphics g) {
//            g.setColor(Color.blue);
//            g.drawLine(pixX[0], pixY[0], pixX[1], pixY[1]);
//            g.drawLine(pixX[1], pixY[1], pixX[2], pixY[2]);
//            g.drawLine(pixX[2], pixY[2], pixX[0], pixY[0]);
//        }
//    };
//
//    public class NaslCl extends Frame {
//
//        Color clr = new Color(255, 50, 50);
//        ThrAng TAng;
//        Line lne;
//        Square Sqr;
//        Toolkit toolkit;
//        Timer timer;
//        Graphics g;
//
//        public NaslCl() {
//            super("Наследование классов");
//            setSize(900, 800);
//            setVisible(true);
//            toolkit = Toolkit.getDefaultToolkit();
//            timer = new Timer();
//            timer.schedule(new RemindTask(),
//                    0, //initial delay
//                    1 * 1000);  //subsequent rate
//            TAng = new ThrAng(100, 100, 0, 10, clr);
//            lne = new Line(100, 100, 0, 10, clr);
//            Sqr = new Square(100, 100, 0, 10, clr);
//        }
//
//        public void paint(Graphics g) {
//            setBackground(Color.blue);
//            Color clr = new Color(255, 50, 50);
//            g.setColor(clr);
//            this.g = g;
//            lne.draw(g);
//            Sqr.draw(g);
//            TAng.draw(g);
//        }
//
//        class RemindTask extends TimerTask {
//
//            public void run() {
//                lne.step(200, 200, 2, lne.Pos, lne.pixX, lne.pixY);
//                toolkit.beep();
//            }
//        }
//
//        public static void main(String ar[]) {
//            new NaslCl();
//        }
//
//        public boolean handleEvent(Event e) {
//            switch (e.id) {
//                case Event.WINDOW_DESTROY:
//                    dispose();
//                    System.exit(0);
//                    return true;
//                default:
//                    return super.handleEvent(e);
//            }
//        }
//    }
//
//}
