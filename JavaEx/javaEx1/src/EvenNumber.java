public class EvenNumber {
    public static void main(String[] args) {
        int i = 0, sum = 0;

        while (i <= 20){
            if(i % 2 == 0){
                sum+=i;
            }
            i++;
        }
        System.out.println("Sum of first 10 even numbers is: "+sum);
    }

}
