package Personnel.repository;

import Personnel.entity.PersonnelRoot;
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
import java.util.ArrayList;
import java.util.List;


public class Respository {
    PersonnelRoot personnelRoot = new PersonnelRoot();
    public PersonnelRoot loadFromFileJson() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("Personnel.json"));
        personnelRoot = gson.fromJson(reader,PersonnelRoot.class);
        reader.close();
        return personnelRoot;
    }

    public void saveToFile(Object objects) throws IOException {
        String fileName = "Personnel.json";
        Path path = Paths.get(fileName);
        Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement tree = gson.toJsonTree(objects);
        gson.toJson(tree,writer);
        writer.close();
    }


}
