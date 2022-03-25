//working with file
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadCustomer {
    //1. Demo read file with Json Library
    public void getDataWithJson() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        try{//read json file
            FileReader reader = new FileReader("customer.json");
            Object obj = parser.parse(reader);

            JSONArray customerList = (JSONArray) obj;

            customerList.forEach(cus -> parseCustomerObject((JSONObject) cus));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void parseCustomerObject(JSONObject jsonObject) {

        long id = (long)jsonObject.get("id");
        String first_name = (String) jsonObject.get("first_name");
        String last_name = (String) jsonObject.get("last_name");
        String mobile = (String) jsonObject.get("mobile");
        String address = (String) jsonObject.get("address");

        System.out.println(id + "-" + first_name + "-" + last_name + "-" + mobile + "-" + address);

    }
    //2. Demo read file with Gson Library
    public void getDataWithGson(){
        Gson gson = new Gson();
        List<Customer> customerList;
        try {
            FileReader reader = new FileReader("customer.json");
            customerList = new Gson().fromJson(reader, new TypeToken<List<Customer>>(){}.getType());
            for (Customer customer: customerList){
                System.out.println(customer);
            }
        }catch (FileNotFoundException ex){
            System.out.println("Khong tim thay file, kiem tra lai !!!");
        }
    }
}
