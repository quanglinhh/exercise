public class OverLoadingDemo {
    public  void tinhtong(int a, int b){
        int kq = a + b;
        System.out.println(kq);
    }

    public void tinhtong(float c, float d){
        float kq = c + d;
        System.out.println(kq);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        OverLoadingDemo o = new OverLoadingDemo();
        o.tinhtong(a,b);
    }
}
