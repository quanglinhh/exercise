package com.example.deamon;

public class App {
    public static void main(String[] args) {
        System.out.println("Main Thread");
        Thread deamonThread = new DeamonThread();
        deamonThread.setDaemon(true);//Lúc này nó mới là một luồng deamon thread
        deamonThread.start();

        new NoneDeamonThread().start();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main Thread stopped");
    }
}
