import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        ReadCustomer readCustomer = new ReadCustomer();
        System.out.println("JSON Library==================");
        readCustomer.getDataWithJson();
        System.out.println("JSON Library==================");
        readCustomer.getDataWithGson();
        */
         Authentication authentication = new Authentication();
         boolean status = authentication.checkLogin("admin","12345");
         if(status){
             ReadCustomer readCustomer = new ReadCustomer();
             System.out.println("JSON Library==================");
             readCustomer.getDataWithJson();
             System.out.println("JSON Library==================");
             readCustomer.getDataWithGson();
         }else{
             System.out.println("Invalid user and password");
         }
    }
}
