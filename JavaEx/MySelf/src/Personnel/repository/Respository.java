package Personnel.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import Personnel.entity.Personnel;

import org.json.simple.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Respository {

    public void loadFromFileJson(){

        try{
            Reader reader = new FileReader("Personnel.json");
            Type type = new TypeToken<List<Personnel>>(){}.getType();

    

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveToFile(List<Object> objects,int ch) throws IOException {

        JSONObject object = new JSONObject();
        object.get("Worker");
        String fileName = "Personnel.json";
        Path path = Paths.get(fileName);
        Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement tree = gson.toJsonTree(objects);
        gson.toJson(tree,writer);
        writer.close();
        System.out.println("Ghi file thanh cong");


    }

    public static void main(String[] args) {
        Respository respository = new Respository();
        respository.loadFromFileJson();
    }
}
