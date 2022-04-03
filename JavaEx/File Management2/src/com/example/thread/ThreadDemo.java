package com.example.thread;

public class ThreadDemo {
    //Main thread: Mac dinh o day se start mot luong main
    public static void main(String[] args) throws  InterruptedException{
        int index = 1;
        for (int i = 0;  i<10; i++) {
            System.out.println("Thread demo1" + index++);

            Thread.sleep(1000);

        }

        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        threadDemo2.start();

//        ThreadDemo3 threadDemo3 = new ThreadDemo3();
//        threadDemo3.run();

        Thread threadDemo31 = new Thread(new ThreadDemo3());
        threadDemo31.start();

        System.out.println("Thread main stopped");
    }
}
