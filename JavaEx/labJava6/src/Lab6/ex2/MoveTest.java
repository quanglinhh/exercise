package Lab6.ex2;

import java.util.Scanner;

public class MoveTest {

    public static void display(){
        int choice;
        Scanner input = new Scanner(System.in);
        NovablePoint novablePoint = new NovablePoint();

        System.out.println("Chọn phương thức di chuyển: ");
        System.out.println("1. Lên");
        System.out.println("2. Xuống");
        System.out.println("3. Trái");
        System.out.println("4. Phải");
        System.out.println("-----------------------------------");
        choice = input.nextInt();

        switch (choice){
            case 1:
                novablePoint.moveUp();
                System.out.println("Tọa độ hiện tại là: ("+novablePoint.getX()+","+novablePoint.getY()+")");
                display();
                break;
            case 2:
                novablePoint.moveDown();
                System.out.println("Tọa độ hiện tại là: ("+novablePoint.getX()+","+novablePoint.getY()+")");
                display();
                break;
            case 3:
                novablePoint.moveLeft();
                System.out.println("Tọa độ hiện tại là: ("+novablePoint.getX()+","+novablePoint.getY()+")");
                display();
                break;
            case 4:
                novablePoint.moveRight();
                System.out.println("Tọa độ hiện tại là: ("+novablePoint.getX()+","+novablePoint.getY()+")");
                display();
                break;
        }
    }
    public static void main(String[] args) {
    display();
    }
}
