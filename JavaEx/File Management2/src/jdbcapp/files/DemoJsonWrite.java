package jdbcapp.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoJsonWrite {


    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        DemoJsonWrite.writeDemo1();
//        DemoJsonWrite.writeDemo2();
//        writeDemo3();
//        readDemo();
        readDemoObject();
//        readDemoFromMap();
    }

    public static void writeDemo1() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "linh");
        map.put("email", "linh@gmail.com");
        map.put("roles", new String[]{"Admin", "Member", "Employee"});
        map.put("Admin", true);
        map.put("Employee", true);
        //User 1-* Roles

        //Ghi file: su dung class writer
        Writer writer = new FileWriter("user1.json");

        //Covert to json
        Gson gson = new Gson();
        gson.toJson(map, writer);
        //Close the writer
        writer.close();
        System.out.println("Ghi file json thanh cong");


    }

    public static void writeDemo2() throws IOException {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student(100, "Student1");
        Student student2 = new Student(200, "Student2");
        Student student3 = new Student(300, "Student3");
        Student student4 = new Student(400, "Student4");
        Student student5 = new Student(500, "Student5");
        Student student6 = new Student(600, "Student6");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        Student student7 = new Student(700,"Student7");
        students.add(student7);

        String fileName = "student.json";
        Path path = Paths.get(fileName);
        //Buffer : ghi nhanh hơn nhờ vùng đệm buffer tăng tốc độ ghi file
        Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement tree = gson.toJsonTree(students);
        gson.toJson(tree, writer);
        writer.close();



        /*
        Writer writer1 = Files.newBufferedWriter(Paths.get("student.json"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(writer1);
        writer1.close();
        System.out.println("Ghi file thanh cong");
         */
    }

    public static void writeDemo3() throws IOException {
        //Create Object
        User user = new User(1, "linh", "linh@gmail.com",
                new String[]{"Member", "Admin", "Employee"}, true, true);
        //Tạo Gson object
        Gson gson = new Gson();
        Path path = Paths.get("user3.json");/**/
        Writer writer = Files.newBufferedWriter(path);
        gson.toJson(user, writer);
        writer.close();
        System.out.println("Thanh cong");
    }

    public static void readDemo() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("student.json"));
        Type type = new TypeToken<List<Student>>(){}.getType();
        students = new Gson().fromJson(reader,type);
        for(Student student : students){
            System.out.println(student);
        }
    }

    public static void readDemoObject() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("user3.json"));
        User user = gson.fromJson(reader,User.class);
        System.out.println(user.id);
        System.out.println(reader);
        reader.close();
    }

    public static void readDemoFromMap() throws IOException{
        Reader reader = Files.newBufferedReader(Paths.get("user1.json"));
        Map<?,?> map = new Gson().fromJson(reader,Map.class);

        for (Map.Entry<?,?> entry: map.entrySet()){
            System.out.println(entry);
        }
    }
}
