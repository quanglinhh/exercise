package com.example.thread;

public class ThreadDemo3 implements Runnable{
    @Override
    public void run() {
        int index = 1;
        for (int i = 0;  i<10; i++){
            System.out.println("Thread demo3"+ index++);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Thread3 stopped");
    }
}
