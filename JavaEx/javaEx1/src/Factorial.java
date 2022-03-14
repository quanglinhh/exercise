import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int num;
        long fact = 1;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of factorial calculation: ");
        num = input.nextInt();

        do{
            fact = fact * num;
            num --;
        }while (num >= 1);

        System.out.println("Factorial of a Number: "+fact);
    }
}
