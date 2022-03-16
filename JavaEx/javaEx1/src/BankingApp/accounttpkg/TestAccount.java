package BankingApp.accounttpkg;

//Importing packages
import BankingApp.bankpkg.Bank;
import java.util.Scanner;

public class TestAccount {
    /**
     *
     * @param args the command line argument
     */
    public static void main(String[] args) {
        try {
            //Declare a String array to store account details
            String[] accountDetails = new String[5];
            //Declare a String array to store bank details
            String[] bankDetails = new String[3];
            //Instantiate the Scanner class
            Scanner input = new Scanner(System.in);

            //Accept the account details
            System.out.print("Enter Account Number: ");
            accountDetails[0] = input.nextLine();//accept account number
            System.out.print("Enter Name: ");
            accountDetails[1] = input.nextLine();//accept account holder name
            System.out.print("Enter Account Type: ");
            accountDetails[2] = input.nextLine();//accept account Type
            System.out.print("Enter Balance: ");
            accountDetails[3] = input.nextLine();//accept balance
            System.out.print("Enter Number of Days: ");
            accountDetails[4] = input.nextLine();//accept number of days

            //Accept the bank details
            System.out.print("Enter Bank ID: ");
            bankDetails[0] = input.nextLine();//accept bank id
            System.out.print("Enter Bank Name: ");
            bankDetails[1] = input.nextLine();//accept bank name
            System.out.print("Enter Bank Branch: ");
            bankDetails[2] = input.nextLine();//accept bank branch

            System.out.println("--------------------------------------");

//        //Declare and instantiate object of type SarvingAccount
//        Account objAccount1 = new Account();
//
//        //Add the details of objAccount1 object
//        objAccount1.addDetails(accountDetals);
//
//        //Display the details of objAccount 1 object;
//        objAccount1.displayDetails();
//        System.out.println("-------------------------------------");
//
//        //Declare and instantiate object of type Bank;
//        Bank objBank1 = new Bank();
//
//        //Add the bank details of objBank1 object
//        objBank1.addBankDetails(bankDetails);
//
//        //Display bank details of objBank1 object
//        objBank1.displayBankDetails();

            //Declare and instantiate object of type SarvingAccount
            SavingsAccount objAccount1 = new SavingsAccount(accountDetails[0],
                    accountDetails[1], accountDetails[2], Double.parseDouble(accountDetails[3]),
                    Integer.parseInt(accountDetails[4]));
            //Display the details of objAccount2 object
            objAccount1.displayDetails();
            System.out.println("---------------------------------------------------");

            //Declare and instantiate object ò type Bank
            Bank objBank1 = new Bank();

            //Ađ the bank details ò objBank1 object
            objBank1.addBankDetails(bankDetails);

            //Display bank details ò objBank1 object
            objBank1.displayBankDetails();

            //Calculate and display daily interest
//        System.out.println("Daily Interest is: $"+objAccount1.calculateInterest());

            //Check account balance
            objAccount1.checkBalance(accountDetails[0]);

            //Deposit cash into the account
            System.out.print("Enter Deposit Amount: ");
            double deposit = Double.parseDouble(input.nextLine());
            //Invoke tje depositCash() method
            objAccount1.depositCash(accountDetails[0], deposit);

            //Withdraw cash form the account
            System.out.print("Enter Withdrawal Amount: ");
            double withdraw = Double.parseDouble(input.nextLine());
            //Invoke the withdrawCash() method
            objAccount1.withdrawCash(accountDetails[0], withdraw);

        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Error: Array Index Out of Bounds");
        }catch (NumberFormatException ex){
            System.out.println("Error: Illegal Argument, "+ex.getMessage());
        }
    }
}
