package Personnel;

import Personnel.controller.Controller;

import java.io.IOException;
import java.util.Scanner;

public class PersonnelApplication {
    public static void menu(){
        System.out.println("===Menu===");
        System.out.println("1. Display All Personnel");
        System.out.println("2. Add Personnel");
        System.out.println("3. Display all Worker");
        System.out.println("4. Display all Engineer");
        System.out.println("5. Display all Staff");
        System.out.println("6. Search Personnel");
        System.out.println("7. Delete Personnel");
        System.out.println("8. Exit");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (true){
            menu();
            int ch = scanner.nextInt();
            switch (ch){
                case 1:
                    controller.displayAllPersonnel();
                    break;
                case 2:
                    choseRoll();
                    int choseRoll = scanner.nextInt();
                    controller.addPersonnel(choseRoll);
                    break;
                case 3:
                    controller.displayPersonnelByRoll(ch);
                    break;
                case 4:
                    controller.displayPersonnelByRoll(ch);
                    break;
                case 5:
                    controller.displayPersonnelByRoll(ch);
                    break;
                case 6:
                    controller.searchPersonnel();
                    break;
                case 7:
                    controller.deletePersonnel();
                    break;
                case 8:
                    break;
            }
        }
    }
    public static void choseRoll(){
        System.out.println("Chose Roll: ");
        System.out.println("1. Worker");
        System.out.println("2. Engineer");
        System.out.println("3. Staff");
    }
}
