import java.util.Scanner;

public class Invoice {
    public static void main(String[] args) {
        int orderShirts, orderedTrousers, points = 0;
        int priceOfShirt = 300;
        int priceOfTrouser = 700;
        int costOfShirts, costOfTrousers, totalCost;
        double discount, netPay;

        //Creates the object of Scanner class
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of Shirts to order:");
        orderShirts = input.nextInt();
        System.out.println("Enter the number of Trousers to order:");
        orderedTrousers = input.nextInt();

        costOfShirts = priceOfShirt * orderShirts;
        costOfTrousers = priceOfTrouser * orderedTrousers;
        totalCost = costOfShirts + costOfTrousers;

        discount = totalCost > 3000 ? totalCost * 10/100 : 100;
        netPay = totalCost-discount;

        System.out.println("\nItem \t\t Quantity \t Price \t\t Total");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("Shirts \t\t %d \t\t\t %d \t\t %d \n", orderShirts,priceOfShirt,costOfShirts);
        System.out.printf("Trousers \t %d \t\t\t %d \t\t %d \n",orderedTrousers, priceOfTrouser, costOfTrousers);
        System.out.printf("Discount \t \t\t \t\t %2f \n", discount);
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("Net Total \t \t\t \t\t %.2f \n",netPay);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("Points Earned \t %d \n",points);


    }
}
