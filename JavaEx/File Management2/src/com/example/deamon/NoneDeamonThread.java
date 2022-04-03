package com.example.deamon;

import com.example.thread.ThreadDemo2;

public class NoneDeamonThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        while (i<20){
            System.out.println("None Deamon Thread" +i++);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Kết thúc luồng là None Deamon Thread");
    }
}
