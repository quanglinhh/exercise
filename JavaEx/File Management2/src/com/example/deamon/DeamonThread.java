package com.example.deamon;

public class DeamonThread extends Thread{

    public void run() {
        int count = 0;
        while (true){
            System.out.println("Deamon Thread running");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
