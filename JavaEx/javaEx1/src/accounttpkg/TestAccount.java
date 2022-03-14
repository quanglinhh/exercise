package accounttpkg;

//Importing packages
import bankpkg.Bank;
import java.util.Scanner;

public class TestAccount {
    /**
     *
     * @param args the command line argument
     */
    public static void main(String[] args) {

        //Declare a String array to store account details
        String[] accountDetals = new String[4];
        //Declare a String array to store bank details
        String[] bankDetails = new String[3];
        //Instantiate the Scanner class
        Scanner input = new Scanner(System.in);

        //Accept the account details
        System.out.print("Enter Account Number: ");
        accountDetals[0] = input.nextLine();//accept account number
        System.out.print("Enter Name: ");
        accountDetals[1] = input.nextLine();//accept account holder name
        System.out.print("Enter Account Type: ");
        accountDetals[2] = input.nextLine();//accept account Type
        System.out.print("Enter Balance: ");
        accountDetals[3] = input.nextLine();//accept balance

        //Accept the bank details
        System.out.print("Enter Bank ID: ");
        bankDetails[0] = input.nextLine();//accept bank id
        System.out.print("Enter Bank Name: ");
        bankDetails[1] = input.nextLine();//accept bank name
        System.out.print("Enter Bank Branch: ");
        bankDetails[2] = input.nextLine();//accept bank branch

        System.out.println("--------------------------------------");
        //Declare and instantiate object of type Account
        Account objAccount1 = new Account();

        //Add the details of objAccount1 object
        objAccount1.addDetails(accountDetals);

        //Display the details of objAccount 1 object;
        objAccount1.displayDetails();
        System.out.println("-------------------------------------");

        //Declare and instantiate object of type Bank;
        Bank objBank1 = new Bank();

        //Add the bank details of objBank1 object
        objBank1.addBankDetails(bankDetails);

        //Display bank details of objBank1 object
        objBank1.displayBankDetails();

    }
}
