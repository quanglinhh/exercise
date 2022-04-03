package part4.ex2;

public class EndThread extends Thread{
    @Override
    public void run() {
        System.out.println("Main thread exiting");
    }
}
