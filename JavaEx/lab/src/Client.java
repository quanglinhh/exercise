public class Client {
    public static void main(String[] args){
        Rectangle rectangle1;
        Rectangle rectangle2;

        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle(10,5);

        rectangle1.display();
        rectangle1.getArea();
        rectangle1.getPerimeter();


        rectangle2.setHeight(10);
        rectangle2.display();
        rectangle2.getArea();
        rectangle2.getPerimeter();

    }
}
