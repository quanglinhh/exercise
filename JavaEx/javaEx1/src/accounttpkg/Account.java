package accounttpkg;

//Importing packages
import java.util.ArrayList;
import java.util.Iterator;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountHolderName;
    private String accountType;
    private ArrayList accDetails = new ArrayList();
    /**
     *Adds account details
     *
     * @return void
     */
    public void addDetails(String[] details){
        System.out.println("Adding Account Details. Please wait...");

        //Copy array to ArrayList using for loop
        for (int i = 0; i <details.length; i++){
            //add array element to ArrayList using add() method
            accDetails.add(details[i]);
        }
    }

    /**
     * Display account detail
     *
     * @return void
     */
    public void displayDetails(){
        System.out.println("Account Details of Customer");
        System.out.println("A/c No. Name \t\t Type \t Balance");
        //Instantiate Iterator reference anf attach int with the ArrayList
        Iterator iAccount = accDetails.iterator();
        //Iterate through the ArrayList to display account details
        while (iAccount.hasNext()){
            //print the account details
            System.out.println(iAccount.next() + "\t");
        }
        System.out.println("");
    }
}
