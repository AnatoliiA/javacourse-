/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author Kamarali Anatolii
 */
public class Main {

    // Неявная форма создания главного потока в программе
    public static void main(String[] args) {
        // Главный поток создается автоматически без нашего участия 
        // Тут вытащили на него ссылку с java
        Thread mainthread = Thread.currentThread();
        System.out.println("" + mainthread.getPriority());
        mainthread.setPriority(10);
        System.out.println("" + mainthread.getPriority());
        // Thread[main,5,main] [поток приоретет группа потока]
        // Приоритеты от 0 до 10  10 наивышший
        // поток можно усыпить метод sleep
        //        try {
        //            mainthread.sleep(6000);
        //        } catch (Exception e) {
        //
        //        }
        //      System.out.println("wake up");

        Person vasy = new Person("Вася");
        Person petya = new Person("Петя");
        Person kostay = new Person("Костя");
        // Cоздать класс которій наледует Thread 
        // Екстендит раннбл 
        ExtendsRunnableThread print1 = new ExtendsRunnableThread(petya);
        ExtendsRunnableThread print0 = new ExtendsRunnableThread(vasy);
        ExtendsRunnableThread print2 = new ExtendsRunnableThread(kostay);
        // запуск происходит с помощью start a не run
        print0.start();
        print2.start();
        print1.start();
        //    Имплементить Runnable
        ImplimentRunnablePrint printTime = new ImplimentRunnablePrint();
        // Скармливаем потоку
        Thread potok = new Thread(printTime);
        potok.start();
//        try {
//            // майну жадать print0 и т.д.
//             join метод заставляется
//            print0.join();
//            print1.join();
//            print2.join();
//            potok.join();
//        } catch (Exception e) {
//        }
        System.out.println(" Главный поток закончил работу " + mainthread);
    }
// Есть четыре потока
// четвертый принтит тайм
// 
}
