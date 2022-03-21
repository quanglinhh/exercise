package Lab6.ex1;

import java.util.Scanner;


public class TestShape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();


        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("1.Hinh chu nhat");
        System.out.println("2.Hinh tam giác");
        System.out.println("-------------------------------------");
        System.out.print("Chon hinh ban muon ve: ");
        number = input.nextInt();

        switch(number){
            case 1:
                System.out.println("Bạn chọn vẽ hình chữ nhật");
                System.out.print("Nhập kích thước chiều dài hình chữ nhật mà bạn muốn vẽ: ");
                rectangle.setLength(input.nextDouble());
                System.out.print("Nhập kích thước chiều rộng hình chữ nhật mà bạn muốn vẽ: ");
                rectangle.setWidth(input.nextDouble());
                System.out.print("Hình chữ nhật mà bạn muốn vẽ có diện tích là: "+ rectangle.getArea());
                break;
            case 2:
                System.out.println("Bạn chọn hình tam giác");
                System.out.print("Nhập kích thước độ dài cạnh đáy hình tam giác mà bạn muốn vẽ: ");
                triangle.setBase(input.nextDouble());
                System.out.print("Nhập kích thước chiều cao hình tam giác mà bạn muốn vẽ");
                triangle.setHeight(input.nextDouble());
                System.out.print("Hình tam giác mà bạn muốn vẽ có diện tích là: "+ triangle.getArea());
                break;
        }
    }
}