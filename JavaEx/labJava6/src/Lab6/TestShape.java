package Lab6;

import java.util.Scanner;

public class TestShape {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        double length;
        double width;
        double base;
        double height;
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("1.Hinh chu nhat");
        System.out.println("2.Hinh tam giác");
        System.out.println("-------------------------------------");
        System.out.print("Chon hinh ban muon ve: ");
        number = input.nextInt();

        switch(number){
            case 1:
                System.out.println("Ban chon tinh dien tich hinh chu nhat");
                System.out.print("Nhap vao chieu dai cua hinh chu nhat");
                height = input.nextInt();
                System.out.print("Dien tich cua hinh chu nhat la: ");

                break;
            case 2:
                System.out.print("Dien tich cua hinh tam giac la");

                break;
        }
    }
}