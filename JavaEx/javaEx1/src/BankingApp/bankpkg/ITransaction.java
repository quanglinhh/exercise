/**
 * ITransaction java
 *
 * This program designs the ITransaction interface
 *
 * Copyright ...
 */
package BankingApp.bankpkg;

/**
 *
 * @author vincent
 */
public interface ITransaction {

    //Declare abstract method
    public void checkBalance(String accountNumber);
    public void depositCash(String accountNumber, double amount);
    public void withdrawCash(String accountNumber, double amount);
}
