package join;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------Main Thread starting....");
        Thread joinThreadA = new JoinThread("A*",2);
        Thread joinThreadB = new JoinThread("B*",3);
        Thread nonJoinThreadC = new JoinThread("C*",5);

        joinThreadA.start();
        joinThreadB.start();
        nonJoinThreadC.start();

        joinThreadA.join();
        joinThreadB.join();

        //Chờ cho ThreadA và ThreadB done thì message được gọi
        System.out.println("Message form main thread...");
        System.out.println("Thead A isLive? "+joinThreadA.isAlive());
        System.out.println("Thead B isLive? "+joinThreadB.isAlive());
        System.out.println("Thead C isLive? "+nonJoinThreadC.isAlive());

        System.out.println("----------Main thread end");
    }
}
