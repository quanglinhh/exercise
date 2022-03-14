import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        long customerCode;
        String customerName;
        int customerAge;
        double depositAmount;

        System.out.println("Enter the details for the new customer. ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Four-digit Customer Code: ");
        customerCode = input.nextLong();
        System.out.println("Enter the Customer First Name: ");
        customerName = input.next();
        System.out.println("Enter the Customer Age: ");
        customerAge = input.nextInt();
        System.out.println("Enter the Amount Deposited:");
        depositAmount = input.nextDouble();

        System.out.println("\nCustomerCode \t\t CustomerName \t\t CustomerAge \t\t DepositAmount");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.format("%08d \t\t\t\t", customerCode);
        System.out.format("%s \t\t\t\t",customerName);
        System.out.format("%d \t\t\t\t", customerAge);
        System.out.format("%.2f\n",depositAmount);
    }
}
