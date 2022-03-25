import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Authentication {
    public boolean checkLogin(String username, String password) throws FileNotFoundException{
        //1. Read file json
        JSONParser parser = new JSONParser();
        try{//read json file
            FileReader reader = new FileReader("user.json");
            Object obj = parser.parse(reader);

            JSONArray userList = (JSONArray) obj;

            userList.forEach(user -> parseCustomerObject((JSONObject) user));


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {

        } catch (ParseException e) {
            e.printStackTrace();
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
