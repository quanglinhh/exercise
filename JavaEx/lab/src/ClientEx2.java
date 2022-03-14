public class ClientEx2 {
    public static void main(String[] args){
        Templature templatureA;
        Templature templatureB;

        templatureA = new Templature();
        templatureB = new Templature(30);

        templatureA.getCTemp();
        templatureA.getFTemp();
        templatureA.getKTemp();
        templatureB.getCTemp();
        templatureB.getFTemp();
        templatureB.getKTemp();

    }
}
