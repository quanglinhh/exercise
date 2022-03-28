import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Authentication {
    public boolean checkLogin(String username, String password) {
        //1. Read file json
        Gson gson = new Gson();
        List<User> userList;
        try {
            FileReader reader = new FileReader("customer.json");
            userList = new Gson().fromJson(reader, new TypeToken<List<User>>(){}.getType());
            for (User user: userList){
                System.out.println(user);
            }
            userList.equals(username);
        }catch (FileNotFoundException ex){
            System.out.println("Khong tim thay file, kiem tra lai !!!");
        }
        //2. Compare value from json with input update


        //3. Check turning flow (if(true) else...)



        return false;
    }

    public void parseCustomerObject(JSONObject user) {
        String user_name = (String) user.get("user_name");
        String password = (String) user.get("password");


    }


}
