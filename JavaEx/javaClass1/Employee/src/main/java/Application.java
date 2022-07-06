import controller.Controller;
import entity.Employee;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
       Run();
    }
    public static void Run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        int choice = 0;
        try{while (choice != 7){
            menu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    controller.displayAllEmployee();
                    break;
                case 2:
                    choseRoll();
                    int choiceRoll = scanner.nextInt();
                    controller.addEmployee(choiceRoll);
                    break;
                case 3:
                    controller.displayWorker();
                    break;
                case 4:
                    controller.displayEngineer();
                    break;
                case 5:
                    controller.displayStaff();
                    break;
                case 6:
                    controller.searchEmployeeByName();
                    break;
                case 7:
                    System.out.println("Exit!!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }}catch (InputMismatchException e){
            System.out.println(e.fillInStackTrace());
            Run();
        }

    }
    public static void menu(){
        System.out.println("===Menu===");
        System.out.println("1. Display All Employee");
        System.out.println("2. Add Employee");
        System.out.println("3. Display all Worker");
        System.out.println("4. Display all Engineer");
        System.out.println("5. Display all Staff");
        System.out.println("6. Search Employee by name");
        System.out.println("7. Exit");
    }
    public static void choseRoll(){
        System.out.println("1. Worker");
        System.out.println("2. Engineer");
        System.out.println("3. Staff");
        System.out.println("Chose Roll: ");
    }
}
