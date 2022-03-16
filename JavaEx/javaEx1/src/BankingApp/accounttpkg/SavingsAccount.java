package BankingApp.accounttpkg;

import BankingApp.bankpkg.Bank;
import java.text.DecimalFormat;
import BankingApp.bankpkg.ITransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SavingsAccount extends Account implements ITransaction{
    //Declare instance vaiables
    private double dailyInterest;
    private int dayOfYear;

    //Parameterized constructor
    public SavingsAccount(String accountNumber, String accountHolderName,
                           String accountType, double balance, int dayOfYear){
        //Invoke super class constructor
        super(accountNumber, accountHolderName, accountType, balance);

        this.dayOfYear = dayOfYear;
    }
    /**
     * Calculates daily interest
     *
     * @return void
     */
    public double calculateInterest(){
        //Calculate daily interest using balance variable from super class
        //and interestRate variable of Bank class
        dailyInterest = (super.getBalance() * Bank.interestRate/100)/dayOfYear;

        //Instantiate class DecimalFormat to get two digit precision
        DecimalFormat twoDForm = new DecimalFormat("#.00");

        //Return the two digit precision value
        return  Double.valueOf(twoDForm.format(dailyInterest));
    }
    /**
     * Displays all details of customer
     * Overridden method
     * @return void
     */
    @Override
    public void displayDetails(){

        //Invoke super class method
        super.displayDetails();

        //Invoke calculateInterest() method
        System.out.println("Daily Interest is: $"+calculateInterest());
        System.out.println("------------------------------------------");
    }

    @Override
    public void checkBalance(String accountNumber) {
        System.out.println("---------------------------------------------");
        System.out.println("Available balance: $ "+super.getBalance());
        System.out.println("---------------------------------------------");
    }

    /**
     * Method to deposit money
     * Overridden method
     *
     * @return void
     */
    @Override
    public void depositCash(String accountNumber, double amount) {
        //Add the value of amount to the existing balance
        super.setBalance(super.getBalance()+amount);

        //Create Calendar class instance
        Calendar objNow = Calendar.getInstance();

        //Create SimpleDateFormat class instance to set date format
        SimpleDateFormat objFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //Format the date using the format() method and print it
        System.out.println("Dte-Time:"+objFormat.format(objNow.getTime()));
        System.out.println("Amount deposited: "+amount);
        System.out.println("Balance after deposit: $"+ super.getBalance());
        System.out.println("---------------------------------------------------");
    }

    @Override
    public void withdrawCash(String accountNumber, double amount) {
        //Add the value of amount to the existing balance
        super.setBalance(super.getBalance()-amount);

        //Create Calendar class instance
        Calendar objNow = Calendar.getInstance();

        //Create SimpleDateFormat class instance to set date format
        SimpleDateFormat objFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //Format the date using the format() method and print it
        System.out.println("Dte-Time:"+objFormat.format(objNow.getTime()));
        System.out.println("Amount withdrawn: "+amount);
        System.out.println("Balance after withdrawal: $"+ super.getBalance());
        System.out.println("---------------------------------------------------");
    }
}
