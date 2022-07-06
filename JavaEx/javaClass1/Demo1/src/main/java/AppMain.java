public class AppMain {
    public static void main(String[] args) {
        DongVat d = new Dog();
        d.keu();

        if(d instanceof Dog){
            System.out.println("D is Dog");
        }
    }
}
