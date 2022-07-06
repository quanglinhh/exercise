package Ex1;

import java.util.Scanner;

public class Ex1_p1 {
    public static void main(String[] args) {
        System.out.println("Nhap so thap phan can chuyen");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        double binaryNumber = 0;
        int du;
        double count = 0.1;
        while (number != 0){
             du = number % 2;
             number = number/2;
             binaryNumber =binaryNumber/10+du;
             count*=10;
        }
        int result = (int) (binaryNumber*count);
        System.out.println(result);
    }


}
