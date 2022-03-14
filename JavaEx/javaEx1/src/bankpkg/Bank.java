/**
 * Bank.java
 *
 * This program design the Bank class
 *
 * Copyright...
 */

package bankpkg;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author vincent
 */
public class Bank {

    //Declaring instance variabless
    String bankID;
    String bankName;
    String branch;
    //Declaring and instantiate an Arraylist
    private ArrayList bankDetails = new ArrayList();
    //Declaring and initialize a static final variable to store interset rate
    public static final float interestRate = 3.5F;
    /**
     * No argumant constructor. Initializes the variable to default values.
     */

    public Bank(){
        bankID = "Not Speccified";
        bankName = "Not Speccified";
        branch = "Not Speccified";
    }

    /**
     * Parameterized constructor that takes bankID, bankName, and branch
     * arguments. Initializes variables to values specified by the user.
     */
    public Bank(String bankID, String bankName, String branch){
        this.bankID = bankID;
        this.bankName = bankName;
        this.branch = branch;
    }
    /**
     * Adds bank details
     *
     * @return void
     */
    public void addBankDetails(String[] details){
        System.out.println("Adding Bank Details. Please wait ...");

        //coppy array to ArrayList using for loop
        for(int i = 0; i < details.length; i++){
            //add array element to ArrayList using add() method
            bankDetails.add(details[i]);
        }
    }

    /**
     *Dispalays bank details
     *
     * @return void
     */
    public void displayBankDetails(){
        System.out.println("Bank Details of Customer");
        System.out.println("Bank ID, Bank Name \t Branch Interest(%)");
        System.out.println("-------------------------------------------");
        //Instantiate Iterator reference and attach it with the ArrayList
        Iterator iBank = bankDetails.iterator();
        while (iBank.hasNext()){
            System.out.println(iBank.next() + " ");
        }
        System.out.println(interestRate);
        System.out.println(" ");
    }
}
