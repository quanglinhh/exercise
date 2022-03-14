public class typeCasting {
    public static void main(String[] args){
        int myInt1 = 9;
        double myDouble1 = myInt1;// Automatic casting: int to double
        double myDouble2 = 9.78d;
        int myInt2 = (int) myDouble2;// Manual casting: double to int

        System.out.println(myInt1);      // Outputs 9
        System.out.println(myDouble1);   // Outputs 9.0


        System.out.println(myDouble2);   // Outputs 9.78
        System.out.println(myInt2);      // Outputs 9
    }
}
