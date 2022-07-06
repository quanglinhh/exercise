package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import entity.EmployeeRoot;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Repository {
    EmployeeRoot employeeRoot = new EmployeeRoot();

    public EmployeeRoot loadFromFileJson() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("Employee.json"));
        employeeRoot = gson.fromJson(reader,EmployeeRoot.class);
        return employeeRoot;
    }

    public void saveToFile(Object objects) throws IOException{
        String fileName = "Employee.json";
        Path path = Paths.get(fileName);
        Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement tree = gson.toJsonTree(objects);
        gson.toJson(tree,writer);
        writer.close();
    }
}
