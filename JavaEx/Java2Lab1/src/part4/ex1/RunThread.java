package part4.ex1;

public class RunThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyJavaThread");

        System.out.println("MyThread renamed: "+myThread.getName());

        myThread.start();
    }
}
