package part4.ex3;



import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int count;
        String message;
        int timeOut;
        String priority;

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of messages: ");
        count = sc.nextInt();

        MessageThread[] messageThread = new MessageThread[count];

            for (int i = 0; i < 2; i++){
                sc.nextLine();
                messageThread[i] = new MessageThread();
                System.out.print("Message "+ (i+1)+ ": ");
                messageThread[i].setMessage(sc.nextLine());
                System.out.print("Timeout: ");
                messageThread[i].setTimeOut(sc.nextInt());
                if(messageThread[i].getTimeOut() == 1000){
                    System.out.println("Priority: high");
                }else {
                    System.out.println("Priority: medium");
                }
            }


        System.out.println("Result:");
        for (int i = 0; i <count; i++){
            messageThread[i].start();
        }
    }
}
