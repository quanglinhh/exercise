import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void employeeManager()throws SQLException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        ControllerEmployee controller = new ControllerEmployee();
        try{while (true){
            menu();
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.print("Nhập vào Employee id: ");
                    int empId = sc.nextInt();
                    System.out.print("Nhập vào Employee No: ");
                    sc.nextLine();
                    String empNo = sc.nextLine();
                    System.out.print("Nhập vào Employee Name: ");
                    String empName = sc.nextLine();
                    controller.addEmployee(empId,empNo,empName);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Nhập vào tên bạn muốn tìm: ");
                    String name = sc.nextLine();
                    controller.getEmployeeByName(name);
                    break;
                case 3:
                    controller.getAllEmployee();
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Nhập tên Employee mà bạn muốn edit: ");
                    String nameEdit = sc.nextLine();
                    controller.editEmployee(nameEdit);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.print("Nhập vào tên Employee mà bạn muốn xóa: ");
                    String nameRemove = sc.nextLine();
                    controller.deleteEmployee(nameRemove);
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
            }
        }}catch (InputMismatchException e){
            System.out.println("Sai cú pháp !");
            Main.employeeManager();
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Main.employeeManager();
    }
    public static void menu(){
        System.out.println("=========Menu========");
        System.out.println("1. Add employee");
        System.out.println("2. Get employee by name");
        System.out.println("3. Get all employees");
        System.out.println("4. Edit employee detail");
        System.out.println("5. Delete employee");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }
}