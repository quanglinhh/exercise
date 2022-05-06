package jdbcapp.mvc.view;

import jdbcapp.mvc.controller.LoginController;
import jdbcapp.mvc.entity.Users;
import jdbcapp.mvc.model.LoginDAOImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginConsole {
    private final Scanner sc;
    //Step1 goi controller
    LoginController loginController = new LoginController();
    Users user = new Users();

    public LoginConsole(){
        this.sc = new Scanner(System.in);

    }
    public int menu(){
        System.out.println("=====Login=====");
        System.out.println("1. Login Statement");
        System.out.println("2. Login Prepare Statement");
        System.out.println("3. Exit");

        int choice = readInt(0,3);
        return choice;
    }
    public int readInt(int min, int max){
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice>=min && choice <= max){
                    break;
                }
            }catch (NumberFormatException numberFormatException){
                numberFormatException.printStackTrace();
            }
        }
        return choice;
    }
    public void loginStatement() throws SQLException, ClassNotFoundException {
        //Scanner
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        user.setUserName(userName);
        System.out.println("Enter user password: ");
        String password = sc.nextLine();
        user.setPassword(password);

        loginController.loginStatementController(user);
    }

    public void loginPrepareStatement() throws SQLException, ClassNotFoundException {
        //Scanner
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        user.setUserName(userName);
        System.out.println("Enter user password: ");
        String password = sc.nextLine();
        user.setPassword(password);
        loginController.loginPrepareStatementController(user);

    }
    public void start() throws SQLException, ClassNotFoundException {
        while (true){
            int choice = menu();
            switch (choice){
                case 3:
                    System.exit(0);
                    break;
                case 1:
                    loginStatement();
                    break;
                case 2:
                    loginPrepareStatement();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
