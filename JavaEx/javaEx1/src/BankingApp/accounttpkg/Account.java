package BankingApp.accounttpkg;

//Importing packages
import java.util.ArrayList;
import java.util.Iterator;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountHolderName;
    private String accountType;
//    private ArrayList accDetails = new ArrayList();

    public Account(String accountNumber, String accountHolderName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
    }

    /**
     *Adds account details
     *
     * @return void
     */
//    public void addDetails(String[] details){
//        System.out.println("Adding Account Details. Please wait...");
//
//        //Copy array to ArrayList using for loop
//        for (int i = 0; i <details.length; i++){
//            //add array element to ArrayList using add() method
//            accDetails.add(details[i]);
//        }
//    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }



    //

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }



    /**
     * Display account detail
     *
     * @return void
     */
    public void displayDetails() {
        System.out.println("All Account Details of Customer");
        System.out.println("-----------------------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }
}
