public class Product {
    public static void main(String[] args) {
        int productId = 19845;
        String productName = "MensTrouser";
        char productType = 'A';
        short quantity = 148;
        double productPrice = 15_25_4.56;
        int barcodeNumber = 0b1101_0101_0001_1010;
        boolean availableStatus =true;

        System.out.println("/tProduct Details");
        System.out.println("-------------------------");
        System.out.println("Product Indentification Code: "+ productId);
        System.out.println("Product Name: "+ productName);
        System.out.println("Product Category (A: Apparels G: Gadgets): "+ productType);
        System.out.println("Product Quantity: "+ quantity);
        System.out.println("Product Price: $"+productPrice);
        System.out.println("Product Barcode Number: "+barcodeNumber);
        System.out.println("Product Availability: "+availableStatus);
    }
}
