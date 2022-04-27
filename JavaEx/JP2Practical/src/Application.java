import controller.CustomerController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void menu(){
        System.out.println("=====Menu=====");
        System.out.println("1. Add new customer");
        System.out.println("2. Find by name");
        System.out.println("3. Display all");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");

    }
    public static void customerManager(){
        Scanner sc = new Scanner(System.in);
        CustomerController controller = new CustomerController();


        try{
            while (true){
                menu();
                int ch = sc.nextInt();
                switch (ch){
                    case 1:
                        sc.nextLine();
                        System.out.print("Nhập tên customer: ");
                        String nameAdd = sc.nextLine();
                        System.out.print("Nhập email customer: ");
                        String email = sc.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String phone = sc.nextLine();
                        controller.addCustomer(nameAdd, email, phone);
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.print("Nhập tên Customer bạn muốn tìm: ");
                        String name = sc.nextLine();
                        controller.findCustomerByName(name);
                        break;
                    case 3:
                        controller.displayAll();
                        break;
                    case 4:
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Yêu cầu nhập đúng");
                        customerManager();
                        break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Sai cú pháp !");
            customerManager();
        }
    }

    public static void main(String[] args) {
        customerManager();

    }
}
