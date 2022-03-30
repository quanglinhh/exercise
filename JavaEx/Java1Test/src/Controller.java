import java.util.Scanner;

public class Controller {
    static PhoneBook pb = new PhoneBook();
    static Scanner scanner = new Scanner(System.in);
    static String name, phone;

    static void menu(){
        System.out.println("PHONEBOOK MANAGEMENT");
        System.out.println("1. Insert phone");
        System.out.println("2. Lookup phone");
        System.out.println("3. Delete phone");
        System.out.println("4. Shutdown");
        System.out.println("===============================");

    }

    public static void main(String[] args) throws PhoneBook.CustomException {
        while (true){
            menu();
            int ch = scanner.nextInt();
            System.out.println("Please choose an obtion: ");
            switch (ch){
                case 1:
                    insert();
                    break;
                case 2:
                    lookUp();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
    private static void delete() throws PhoneBook.CustomException {
        scanner.nextLine();
        System.out.println("Input name of peron you wan delete");
        name = scanner.nextLine();
        pb.delete(name);
    }
    private static void insert() throws PhoneBook.CustomException {
        scanner.nextLine();
        System.out.println("Input name: ");
        name =scanner.nextLine();
        System.out.println("Input phone: ");
        phone = scanner.nextLine();
        pb.insert(name, phone);
    }
    private static void lookUp() throws PhoneBook.CustomException {
        scanner.nextLine();
        System.out.println("Input name of peron you wan search: ");
        name = scanner.nextLine();
        pb.lookUp(name);
    }
}
