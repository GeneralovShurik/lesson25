package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
	// ПОТОКИ(Threads)
        //8362

        long time = System.currentTimeMillis();//получаем текущее время операционки
        //for (int i = 0; i < 10000000; i++) {
         //   double d = Math.sin(Objects.hashCode(i)) * Math.exp(i * i); //загружаем процессор для эксперемента
       // }

        // потоки
        Thread t1 = new Thread(() -> {
            System.out.println("В момент запуска: " + Thread.currentThread().getState());
            for (int i = 0; i < 5000000; i++) {
                double d = Math.sin(Objects.hashCode(i)) * Math.exp(i * i);
            }
            }
        );

        Thread t2 = new Thread(() -> {
            for (int i = 5000000; i < 10000000; i++) {
                double d = Math.sin(Objects.hashCode(i)) * Math.exp(i * i);
            }
        });

        t1.getState();

        //выводим состояние потока

        System.out.println("Перед запуском: " + t1.getState());


        // создание потоко, не значит запуск
        // запуск потока на выполнения
        t1.start();
        t2.start();

        System.out.println("После запуска: " + t1.getState());

        try {
            // ожидаем завершенрие дочнрних потоков
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("После выполнения: " + t1.getState());

        System.out.println(System.currentTimeMillis()- time);
    }
}
